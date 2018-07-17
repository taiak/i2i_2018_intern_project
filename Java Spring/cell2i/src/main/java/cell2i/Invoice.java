package cell2i;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "invoice")
@ViewScoped
public class Invoice {
	
	@ManagedProperty(value = "#{auth}")
	private Auth auth;
	
	private String invoice0;
	private String invoice1;
	private String invoice2;
	private String invoice3;
	private String invoice4;
	private String invoice5;
	
	private InvoiceInfo invoiceInfo0;
	private InvoiceInfo invoiceInfo1;
	private InvoiceInfo invoiceInfo2;
	private InvoiceInfo invoiceInfo3;
	private InvoiceInfo invoiceInfo4;
	private InvoiceInfo invoiceInfo5;
	
	private final String magicAt = "@";
	private final String magicUnderscore = "_";
	
	private String invoiceMonth;
	private String invoiceInfo;
	private int count = 6;
	
	@PostConstruct
	public void loadInvoiceInfo() {
		invoiceInfo = ServiceManager.getInvoicesInfo(auth.getUsername(), count);

		splitUserInvoice(invoiceInfo);
		invoiceInfo0 = splitMonthInvoice(invoice0);
		invoiceInfo1 = splitMonthInvoice(invoice1);
		invoiceInfo2 = splitMonthInvoice(invoice2);
		invoiceInfo3 = splitMonthInvoice(invoice3);
		invoiceInfo4 = splitMonthInvoice(invoice4);
		invoiceInfo5 = splitMonthInvoice(invoice5);
	}
	
	private void splitUserInvoice(String usage) {
		String[] splitted = usage.split(magicAt);
		
		invoice0 = splitted[0];
		invoice1 = splitted[1];
		invoice2 = splitted[2];
		invoice3 = splitted[3];
		invoice4 = splitted[4];
		invoice5 = splitted[5];
		
	}
	
	private InvoiceInfo splitMonthInvoice(String usage) {
		String[] splitted = usage.split(magicUnderscore);
		
		String startDate = splitted[0];
		String endDate = splitted[1];
		String cost = splitted[2];
		String paid = isPaid(splitted[3]);
		String month = myMethod(splitted[0]);
		
		InvoiceInfo info = new InvoiceInfo(startDate, endDate, cost, paid, month);
		
		return info;
	}
	
	public String myMethod(String myDate){
		SimpleDateFormat month_date = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		Date date = null;
		try {
			date = sdf.parse(myDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String month_name = month_date.format(date);
		return month_name;
	}
	
	public String isPaid(String value) {
		String returnValue = "NOT PAID";
		if(value.equals("1"))
			returnValue = "PAID";

		return returnValue;
	}
	
	
	public Auth getAuth() {
		return auth;
	}


	public void setAuth(Auth auth) {
		this.auth = auth;
	}


	public String getInvoiceMonth() {
		return invoiceMonth;
	}


	public void setInvoiceMonth(String invoiceMonth) {
		this.invoiceMonth = invoiceMonth;
	}


	public String getInvoiceInfo() {
		return invoiceInfo;
	}


	public void setInvoiceInfo(String invoiceInfo) {
		this.invoiceInfo = invoiceInfo;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

	public String getInvoice0() {
		return invoice0;
	}

	public void setInvoice0(String invoice0) {
		this.invoice0 = invoice0;
	}

	public String getInvoice1() {
		return invoice1;
	}

	public void setInvoice1(String invoice1) {
		this.invoice1 = invoice1;
	}

	public String getInvoice2() {
		return invoice2;
	}

	public void setInvoice2(String invoice2) {
		this.invoice2 = invoice2;
	}

	public String getInvoice3() {
		return invoice3;
	}

	public void setInvoice3(String invoice3) {
		this.invoice3 = invoice3;
	}

	public String getInvoice4() {
		return invoice4;
	}

	public void setInvoice4(String invoice4) {
		this.invoice4 = invoice4;
	}

	public String getInvoice5() {
		return invoice5;
	}

	public void setInvoice5(String invoice5) {
		this.invoice5 = invoice5;
	}

	public InvoiceInfo getInvoiceInfo0() {
		return invoiceInfo0;
	}

	public void setInvoiceInfo0(InvoiceInfo invoiceInfo0) {
		this.invoiceInfo0 = invoiceInfo0;
	}

	public InvoiceInfo getInvoiceInfo1() {
		return invoiceInfo1;
	}

	public void setInvoiceInfo1(InvoiceInfo invoiceInfo1) {
		this.invoiceInfo1 = invoiceInfo1;
	}

	public InvoiceInfo getInvoiceInfo2() {
		return invoiceInfo2;
	}

	public void setInvoiceInfo2(InvoiceInfo invoiceInfo2) {
		this.invoiceInfo2 = invoiceInfo2;
	}

	public InvoiceInfo getInvoiceInfo3() {
		return invoiceInfo3;
	}

	public void setInvoiceInfo3(InvoiceInfo invoiceInfo3) {
		this.invoiceInfo3 = invoiceInfo3;
	}

	public InvoiceInfo getInvoiceInfo4() {
		return invoiceInfo4;
	}

	public void setInvoiceInfo4(InvoiceInfo invoiceInfo4) {
		this.invoiceInfo4 = invoiceInfo4;
	}

	public InvoiceInfo getInvoiceInfo5() {
		return invoiceInfo5;
	}

	public void setInvoiceInfo5(InvoiceInfo invoiceInfo5) {
		this.invoiceInfo5 = invoiceInfo5;
	}


	
	
	
}
