using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using static _180705_i2i_Cell2i.Login;


namespace _180705_i2i_Cell2i
{
    public partial class Info : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Customer customer = new Customer(Login.customer.getPhoneNumber(),Login.customer.getPassword());
            customer.tariffInfoToList();
            customer.usageInfoToListSMS();
            customer.usageInfoToListCall();
            customer.usageInfoToListInternet();
            txt_phone.Text = Login.customer.getPhoneNumber();
            txt_user.Text = Login.customer.getFullname();
            txt_tariff.Text =customer.tariffName();
            //Customer.client2.
            internetUsage((proportion(customer.getInternetUsage(), customer.getInternetLimit())).ToString());
            callUsage((proportion(customer.getCallUsage(), customer.getCallLimit())).ToString());
            messageUsage((proportion(customer.getSMSUsage(), customer.getSMSLimit())).ToString());
            //customer.getInternetLimit();
        }

        protected void imgbtn_exit_Click(object sender, ImageClickEventArgs e)
        {
           
            Session.RemoveAll();
            Page.Response.Redirect("Login.aspx");
        }
        protected void imgbtn_coins_Click(object sender, ImageClickEventArgs e)
        {
            Page.Response.Redirect("Invoice.aspx");
        }

        public void internetUsage(string x)
        {
            customer.tariffInfoToList();
            customer.usageInfoToListInternet();
            string usage = x;
            innerDiv.Style.Add("width", usage + "%");
            innerDiv.InnerText = customer.getInternetUsage()+" MB";
            lbl_internet_usage.Text = (Convert.ToInt32(customer.getInternetLimit())/1000).ToString() + " GB";
        }

        public void callUsage(string x)
        {
            customer.tariffInfoToList();
            customer.usageInfoToListCall();
            string usage = x;
            innerDiv2.Style.Add("width", usage + "%");
            innerDiv2.InnerText = customer.getCallUsage()+" DK";
            lbl_callUsage.Text = customer.getCallLimit() + " DK";
        }

        public void messageUsage(string x)
        {
            customer.tariffInfoToList();
            customer.usageInfoToListSMS();
            string usage = x;
            innerDiv3.Style.Add("width", usage + "%");
            innerDiv3.InnerText = customer.getSMSUsage()+" SMS";
            lbl_messageUsage.Text = customer.getSMSLimit() + " SMS";
        }
        public int proportion(string usage, string max)
        {
            return (Convert.ToInt32(usage)*100) / Convert.ToInt32(max);
        }

    }
}