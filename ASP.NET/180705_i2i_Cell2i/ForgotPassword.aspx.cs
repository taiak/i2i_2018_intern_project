using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace _180705_i2i_Cell2i
{
    public partial class ForgotPassword : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btn_change_Click(object sender, EventArgs e)
        {
            if (canBeChange())      //to do control:....<=====3
            {
                Customer.client2.changeUserPassword(txt_enterPhoneNumber.Text, txt_enterNewPassword.Text);
            }
        }
        public Boolean isValid(string password)
        {
            return (password.Any(char.IsDigit) && (password.Any(char.IsSymbol) || password.Any(char.IsPunctuation))&& password.Min()>8); //min mevzusu kontrol
            
        }
        public Boolean canBeChange()
        {
            if ( txt_enterNewPassword.Text == txt_confirmPassword.Text && isValid(txt_enterNewPassword.Text))
            {
                lbl_statusChangePassword.Text = "Password Confirmed";
                lbl_statusChangePassword.ForeColor=System.Drawing.ColorTranslator.FromHtml("#118f17");
                lbl_statusChangePassword.Visible = true;
                return true;
            }
            else
            {
                lbl_statusChangePassword.Visible = true;
                return false;
            }
        }
    }
}