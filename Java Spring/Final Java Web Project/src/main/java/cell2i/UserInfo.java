package cell2i;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "userInfo")
@ViewScoped
public class UserInfo {

	@ManagedProperty(value = "#{auth}")
	private Auth auth;

	private String userInfo;
	private String mobile;
	private String firstNameLastName;

	private String tariffInfo;
	private String tariffName;
	
	private String tariffVoice;
	private int tariffVoiceInt;
	
	private String tariffSms;
	private int tariffSmsInt;
	
	private String tariffData;
	private Double tariffDataDouble;
	
	private String usageInfoData;
	private String usageInfoSms;
	private String usageInfoVoice;
	
	private List<UsageInfo> usageInfoList = new ArrayList<>();
	

	@PostConstruct
	public void loadUserInfo() {
		userInfo = ServiceManager.getUserInfo(auth.getUsername());
		tariffInfo = ServiceManager.getUserTariffName(auth.getUsername());
		
		usageInfoData = ServiceManager.getUsageInfo(auth.getUsername(), "DATA");
		usageInfoSms = ServiceManager.getUsageInfo(auth.getUsername(), "SMS");
		usageInfoVoice = ServiceManager.getUsageInfo(auth.getUsername(), "VOICE");

		splitUserInfo();
		splitTariffInfo();
		
		splitUsageInfoData(usageInfoData, tariffDataDouble);
		splitUsageInfoVoiceAndSms(usageInfoSms, tariffSmsInt);
		splitUsageInfoVoiceAndSms(usageInfoVoice, tariffVoiceInt);

	}

	private void splitUsageInfoData(String usage, Double tariff) {
		String[] splitted = usage.split("_");
		
		String infoType = splitted[0];
		Double usageDouble = Double.valueOf(splitted[1])/1000;
		
		usageInfoList.add(new UsageInfo(infoType, tariff, usageDouble, (int)((usageDouble/tariff) * 100)));
	}
	
	private void splitUsageInfoVoiceAndSms(String usage, int tariff) {
		String[] splitted = usage.split("_");
		
		String infoType = splitted[0];
		int usageInt = Integer.parseInt(splitted[1]);
		
		usageInfoList.add(new UsageInfo(infoType, tariff, usageInt, (int)(((double)usageInt/tariff) * 100)));
	}	
		
	

	private void splitTariffInfo() {
		String[] splitted = tariffInfo.split("_");

		tariffName = splitted[0];
		tariffVoice = splitted[1];
		tariffSms = splitted[2];
		tariffData = splitted[3];
		
		tariffDataDouble = new Double(tariffData) / 1000;
		tariffSmsInt = Integer.parseInt(tariffSms);
		tariffVoiceInt = Integer.parseInt(tariffVoice);
	}

	private void splitUserInfo() {
		if (userInfo == null) {
			return;
		}

		String[] splitted = userInfo.split("_");

		mobile = splitted[0];
		firstNameLastName = splitted[1] + " " + splitted[2];
	}

	public Auth getAuth() {
		return auth;
	}

	public void setAuth(Auth auth) {
		this.auth = auth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFirstNameLastName() {
		return firstNameLastName;
	}

	public void setFirstNameLastName(String firstNameLastName) {
		this.firstNameLastName = firstNameLastName;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getTariffInfo() {
		return tariffInfo;
	}

	public void setTariffInfo(String tariffInfo) {
		this.tariffInfo = tariffInfo;
	}

	public String getTariffName() {
		return tariffName;
	}

	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}

	public String getTariffDk() {
		return tariffVoice;
	}

	public void setTariffDk(String tariffDk) {
		this.tariffVoice = tariffDk;
	}

	public String getTariffSms() {
		return tariffSms;
	}

	public void setTariffSms(String tariffSms) {
		this.tariffSms = tariffSms;
	}

	public String getTariffGb() {
		return tariffData;
	}

	public void setTariffGb(String tariffGb) {
		this.tariffData = tariffGb;
	}

	public Double getTariffGbDouble() {
		return tariffDataDouble;
	}

	public void setTariffGbDouble(Double tariffGbDouble) {
		this.tariffDataDouble = tariffGbDouble;
	}

	public String getUsageInfoData() {
		return usageInfoData;
	}

	public void setUsageInfoData(String usageInfoData) {
		this.usageInfoData = usageInfoData;
	}

	public List<UsageInfo> getUsageInfoList() {
		return usageInfoList;
	}

	public void setUsageInfoList(List<UsageInfo> usageInfoList) {
		this.usageInfoList = usageInfoList;
	}

	public int getTariffVoiceInt() {
		return tariffVoiceInt;
	}

	public void setTariffVoiceInt(int tariffVoiceInt) {
		this.tariffVoiceInt = tariffVoiceInt;
	}

	public int getTariffSmsInt() {
		return tariffSmsInt;
	}

	public void setTariffSmsInt(int tariffSmsInt) {
		this.tariffSmsInt = tariffSmsInt;
	}


}
