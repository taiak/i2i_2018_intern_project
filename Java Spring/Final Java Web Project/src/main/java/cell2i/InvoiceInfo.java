package cell2i;

public class InvoiceInfo {
	private String startDate;
	private String endDate;
	private String cost;
	private String paidInfo;
	private String month;
	



	public InvoiceInfo(String startDate, String endDate, String cost, String paidInfo, String month) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.cost = cost;
		this.paidInfo = paidInfo;
		this.month = month;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getCost() {
		return cost;
	}


	public void setCost(String cost) {
		this.cost = cost;
	}


	public String getPaidInfo() {
		return paidInfo;
	}


	public void setPaidInfo(String paidInfo) {
		this.paidInfo = paidInfo;
	}
	
	
	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}
	
}
