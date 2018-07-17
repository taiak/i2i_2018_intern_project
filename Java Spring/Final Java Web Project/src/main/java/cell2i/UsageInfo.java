package cell2i;

public class UsageInfo {

	private String infoType;
	private Number tariff;
	private Number usage;
	private int usagePercentage;

	public UsageInfo(String infoType, Number tariff, Number usage, int usagePercentage) {
		this.infoType = infoType;
		this.tariff = tariff;
		this.usage = usage;
		this.usagePercentage = usagePercentage;
	}
	
	public String getType(String infoType) {
		String str = "";
		
		switch (infoType) {
		case "DATA":
			str = "GB";
			break;
		case "VOICE":
			str = "DK";
			break;
			
		case "SMS":
			str = "SMS";
		default:
			break;
		}
		
		return str;
	}

	public Number getTariff() {
		return tariff;
	}

	public void setTariff(Number tariff) {
		this.tariff = tariff;
	}

	public int getUsagePercentage() {
		return usagePercentage;
	}

	public void setUsagePercentage(int usagePercentage) {
		this.usagePercentage = usagePercentage;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public Number getUsage() {
		return usage;
	}

	public void setUsage(Number usage) {
		this.usage = usage;
	}

}
