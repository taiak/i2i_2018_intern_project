using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace _180705_i2i_Cell2i
{
    public partial class Login : System.Web.UI.Page
    {

        public static Customer customer = null;


        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btn_login_Click(object sender, EventArgs e)
        {
            customer = new Customer(getPhoneNumberFromTextBox(), getPasswordFromTextBox());

            if (customer.isAuthenticated() == true)
            {
                Session["phoneNumber"] = getPhoneNumberFromTextBox();
                Session["password"] = getPasswordFromTextBox();
                Page.Response.Redirect("Info.aspx");
            }
            else if (getPasswordFromTextBox() == "" || getPhoneNumberFromTextBox() == "")
            {
                lbl_invalid.Text = "Fields can not be blank";
                lbl_invalid.Visible = true;
                makeTextboxesRed();
            }
            else
            {
                lbl_invalid.Text = "Invalid login";
                lbl_invalid.Visible = true;
                lbl_check.Visible = true;
                makeTextboxesRed();
            }

        }

        public Boolean isNotEqual(string str_given, string str_compared)
        {
            if (str_given.Equals(str_compared)==false) 
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public void makeTextboxesRed()
        {
            txt_phoneNumber.BorderColor = System.Drawing.ColorTranslator.FromHtml("#FF0000");
            txt_password.BorderColor = System.Drawing.ColorTranslator.FromHtml("#FF0000");
        }
        public string getPhoneNumberFromTextBox()
        {
            
            return txt_phoneNumber.Text;
        }
        public string getPasswordFromTextBox()
        {
            return txt_password.Text;
        }


    }
}