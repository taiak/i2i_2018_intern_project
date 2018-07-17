package cell2i;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "auth")
@SessionScoped
public class Auth {

	private String username;
	private String password;
	private boolean authenticated = false;
	private boolean hasError = false;
	private boolean loggedOut = false;
	private boolean hasEmptyFieldError = false;

	public boolean isHasEmptyFieldError() {
		return hasEmptyFieldError;
	}

	public void setHasEmptyFieldError(boolean hasEmptyFieldError) {
		this.hasEmptyFieldError = hasEmptyFieldError;
	}

	public String login() {
		if(password.isEmpty()){
			hasEmptyFieldError = true;
			hasError = false;
			loggedOut = false;
			return "";
		}
		String result = ServiceManager.checkUser(username, password);

		authenticated = Boolean.valueOf(result);

		if (authenticated) {
			return "pages/index?faces-redirect=true";
		}
		hasEmptyFieldError = false;
		hasError = true;
		loggedOut = false;
		return "";
	}

	public String logout() {
		authenticated = false;
		hasError = false;
		loggedOut = true;
		return "/login?faces-redirect=true";
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public boolean isLoggedOut() {
		return loggedOut;
	}

	public void setLoggedOut(boolean loggedOut) {
		this.loggedOut = loggedOut;
	}

}
