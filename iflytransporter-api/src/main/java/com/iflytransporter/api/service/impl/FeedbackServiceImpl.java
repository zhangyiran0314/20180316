package com.iflytransporter.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.mapper.FeedbackMapper;
import com.iflytransporter.api.service.FeedbackService;
import com.iflytransporter.common.bean.Feedback;

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackMapper feedbackMapper;
	@Override
	public int sava(Feedback record) {
		return feedbackMapper.insert(record);
	}

}
