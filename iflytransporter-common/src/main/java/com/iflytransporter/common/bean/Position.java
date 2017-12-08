package com.iflytransporter.common.bean;

import java.util.List;

public class Position {
	
	/*private List<ProvinceBO> listProvince;
	
	public List<ProvinceBO> getListProvince() {
		return listProvince;
	}
	public void setListProvince(List<ProvinceBO> listProvince) {
		this.listProvince = listProvince;
	}*/
	public static class AreaBO{
		private String id;
		private String name;
		public AreaBO(Area area){
			this.id= area.getId();
			this.name = area.getName();
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	public static class CityBO{
		private String id;
		private String name;
		private List<AreaBO> areaList;
		
		public CityBO(City city){
			this.id = city.getId();
			this.name = city.getName();
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<AreaBO> getAreaList() {
			return areaList;
		}
		public void setAreaList(List<AreaBO> areaList) {
			this.areaList = areaList;
		}
		
	}
	public static class ProvinceBO{
		private String id;
		private String name;
		private List<CityBO> cityList;
		
		public ProvinceBO(Province province){
			this.id = province.getId();
			this.name = province.getName();
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<CityBO> getCityList() {
			return cityList;
		}
		public void setCityList(List<CityBO> cityList) {
			this.cityList = cityList;
		}
		
	}
	
}

