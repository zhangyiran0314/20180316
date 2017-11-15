package com.iflytransporter.web.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.iflytransporter.common.bean.Attachment;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.common.utils.UUIDUtil;
import com.iflytransporter.web.conf.ConstantsConfig;
import com.iflytransporter.web.service.AttachmentService;

@Controller
@RequestMapping("/attachment")
public class AttachmentController {
	
	@Autowired
	private AttachmentService attachmentSerivce;
	
	@Autowired
	private ConstantsConfig constantsConfig;
	
	/**
	 * 文件上传
	 * @param file
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody 
	public Map<String,Object> fileUpload(@RequestParam("uploadFile")MultipartFile file, MultipartHttpServletRequest request, HttpServletResponse response) {
		String msg = "";
		if (file.isEmpty()) {
			msg = "File is Empty!";
			return ResponseUtil.failureResult(msg);
		}
		String fileName = file.getOriginalFilename();
		if(StringUtils.isBlank(fileName)){
			return ResponseUtil.failureResult(msg);
		}
		String suffix = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
		/**定义存放目录,目录分为两部分
		 * 1.配置文件目录
		 * 2.日期目录yyyy/MM/dd
		 * 文件名为对应此目录下uuid
		 * */
		String fileUploadPath = constantsConfig.getFilePath();//配置文件目录
		if (!new File(fileUploadPath).exists()) {
			new File(fileUploadPath).mkdirs();
		}
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); //日期存放目录
		String dateFilePath =  sdf.format(currentDate);
		String destDir = fileUploadPath+"/"+dateFilePath;
		if (!new File(destDir).exists()) {
			new File(destDir).mkdirs();
		}
		String fileId = UUIDUtil.UUID();
		String desFilePath = dateFilePath+"/"+fileId+"."+suffix;
		String finalFilePath = fileUploadPath + "/"+dateFilePath+"/"+fileId+"."+suffix;
		try {
			file.transferTo(new File(finalFilePath));
			//保存文件记录
			Attachment attachment = new Attachment();
			attachment.setId(fileId);
			attachment.setCreateDate(currentDate);
			attachment.setUpdateDate(currentDate);
			attachment.setAttachementLink(desFilePath);
			attachment.setAttachementName(fileName);
			int result  = attachmentSerivce.saveAttachment(attachment);
			if(result > 0){
				Map<String,Object> data = new HashMap<String,Object>();
				data.put("attachmentId", fileId);
				data.put("path", desFilePath);
				return  ResponseUtil.successResult(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return  ResponseUtil.failureResult();
		}
		return  ResponseUtil.failureResult();
	}
	/** 下载文件 */
	@RequestMapping(value = "/download", method ={RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public void download(HttpServletRequest request,HttpServletResponse response) {
		String attachmentId = request.getParameter("attachmentId");
		if(StringUtils.isBlank(attachmentId)){
			return ;
		}
		Attachment attachment = attachmentSerivce.queryAttachment(attachmentId);
		if (attachment != null) {
			String fileUploadPath = constantsConfig.getFilePath();//配置文件目录
			File file = new File(fileUploadPath +"/"+attachment.getAttachementLink());
			if (file.exists()) {
				String fileName = attachment.getAttachementName();
				String userAgent = request.getHeader("User-Agent");  
				// 针对IE或者以IE为内核的浏览器：  
				try {
		            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {  
							fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
		            } else {  
		                // 非IE浏览器的处理：  
		            	fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");  
		            }  
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				response.setContentType("application/force-download");// 设置强制下载不打开
				response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
				response.setContentType("application/octet-stream; charset=utf-8");  
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}
