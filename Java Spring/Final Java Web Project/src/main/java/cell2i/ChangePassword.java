package cell2i;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "changepassword")
@SessionScoped
public class ChangePassword{
	private String id;
	private String newPassword;
	private String confirmPassword;
	private boolean hasError = false;
	private boolean hasLengthError = false;
	private boolean hasSpecialError = false;
	private boolean hasEmptyError = false;
	
	public String changePw() {
		int lenghtLimit = 8;
		if(newPassword.isEmpty() || confirmPassword.isEmpty()) {
			hasError = false;
			hasLengthError = false;
			hasSpecialError = false;
			hasEmptyError = true;
			return "";
		}else if(!newPassword.equals(confirmPassword)) {
			hasError = true;
			hasLengthError = false;
			hasSpecialError = false;
			hasEmptyError = false;
			return "";
		}else if(newPassword.length() < lenghtLimit){
			hasError = false;
			hasLengthError = true;
			hasSpecialError = false;
			hasEmptyError = false;
			return "";
		}else if(isSpecialCharacter(newPassword)) {
			hasError = false;
			hasLengthError = false;
			hasSpecialError = true;
			hasEmptyError = false;
			return "";
		}else{
			ServiceManager.changeUserPassword(id, newPassword);
			return "login?faces-redirect=true";
		}
	}

	public boolean isHasEmptyError() {
		return hasEmptyError;
	}

	public void setHasEmptyError(boolean hasEmptyError) {
		this.hasEmptyError = hasEmptyError;
	}

	private static boolean isSpecialCharacter(String c){
		boolean value;
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		 
	    Matcher matcher = pattern.matcher(c);
	 
	    if (!matcher.matches()) {
	    	value = false;  
	    }else{
	        value = true;
	    }
	    return value;
	}
	
	public boolean isHasSpecialError() {
		return hasSpecialError;
	}

	public void setHasSpecialError(boolean hasSpecialError) {
		this.hasSpecialError = hasSpecialError;
	}
	
	public boolean isHasLengthError() {
		return hasLengthError;
	}

	public void setHasLengthError(boolean hasLengthError) {
		this.hasLengthError = hasLengthError;
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}