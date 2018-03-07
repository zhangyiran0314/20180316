package com.iflytransporter.api.bean;

public class QueryOrderParam {

	private Integer pageNo;
	private Integer pageSize;

	private String subscribeSourceId;
	
    private String departureProvinceId;

    private String departureCityId;

    private String departureAreaId;

    private String destinationProvinceId;

    private String destinationCityId;

    private String destinationAreaId;

    private String carTypeId;

    private String tyreNo;

    private Integer carLength;

    private String useTypeId;
    
    private String goodsType;
    
    //货源搜索时,用于判断当前车主是否申请过此货源记录属性
    private String transporterId;
    
    public Long lastCreateDate;
    
    public String than;

	public String getDepartureProvinceId() {
		return departureProvinceId;
	}

	public void setDepartureProvinceId(String departureProvinceId) {
		this.departureProvinceId = departureProvinceId;
	}

	public String getDepartureCityId() {
		return departureCityId;
	}

	public void setDepartureCityId(String departureCityId) {
		this.departureCityId = departureCityId;
	}

	public String getDepartureAreaId() {
		return departureAreaId;
	}

	public void setDepartureAreaId(String departureAreaId) {
		this.departureAreaId = departureAreaId;
	}

	public String getDestinationProvinceId() {
		return destinationProvinceId;
	}

	public void setDestinationProvinceId(String destinationProvinceId) {
		this.destinationProvinceId = destinationProvinceId;
	}

	public String getDestinationCityId() {
		return destinationCityId;
	}

	public void setDestinationCityId(String destinationCityId) {
		this.destinationCityId = destinationCityId;
	}

	public String getDestinationAreaId() {
		return destinationAreaId;
	}

	public void setDestinationAreaId(String destinationAreaId) {
		this.destinationAreaId = destinationAreaId;
	}

	public String getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(String carTypeId) {
		this.carTypeId = carTypeId;
	}

	public String getTyreNo() {
		return tyreNo;
	}

	public void setTyreNo(String tyreNo) {
		this.tyreNo = tyreNo;
	}

	public Integer getCarLength() {
		return carLength;
	}

	public void setCarLength(Integer carLength) {
		this.carLength = carLength;
	}

	public String getUseTypeId() {
		return useTypeId;
	}

	public void setUseTypeId(String useTypeId) {
		this.useTypeId = useTypeId;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getSubscribeSourceId() {
		return subscribeSourceId;
	}

	public void setSubscribeSourceId(String subscribeSourceId) {
		this.subscribeSourceId = subscribeSourceId;
	}

	public String getTransporterId() {
		return transporterId;
	}

	public void setTransporterId(String transporterId) {
		this.transporterId = transporterId;
	}

	public Long getLastCreateDate() {
		return lastCreateDate;
	}

	public void setLastCreateDate(Long lastCreateDate) {
		this.lastCreateDate = lastCreateDate;
	}

	public String getThan() {
		return than;
	}

	public void setThan(String than) {
		this.than = than;
	}
    
    
}
