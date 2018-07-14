using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace _180705_i2i_Cell2i
{
    public partial class Invoice : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Customer customer = new Customer(Login.customer.getPhoneNumber(), Login.customer.getPassword());

            
            printInvoice(txt_TextBox1, (int)Customer.enumOrderOfMonths.MONTH_1);
            printInvoice(txt_TextBox2, (int)Customer.enumOrderOfMonths.MONTH_2);
            printInvoice(txt_TextBox3, (int)Customer.enumOrderOfMonths.MONTH_3);
            printInvoice(txt_TextBox4, (int)Customer.enumOrderOfMonths.MONTH_4);
            printInvoice(txt_TextBox5, (int)Customer.enumOrderOfMonths.MONTH_5);
            printInvoice(txt_TextBox6, (int)Customer.enumOrderOfMonths.MONTH_6);
        }
        public void printInvoice(TextBox txt_Textbox,int orderOfMonth)
        {
            Customer customer = new Customer(Login.customer.getPhoneNumber(), Login.customer.getPassword());
            txt_Textbox.Text = "\n\t"+(customer.getMonthOfInvoice(orderOfMonth).ToUpper() + " INVOICE\n\n\tCost: " + (customer.getMagicalInvoiceData(orderOfMonth, (int)Customer.enumDetailOfInvoice.COST)) + "\n\n\tInvoice date: " + (customer.getMagicalInvoiceData(orderOfMonth, (int)Customer.enumDetailOfInvoice.ENDDATE)) + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + customer.paidOrNotPaid(Convert.ToInt16(customer.getMagicalInvoiceData(orderOfMonth, (int)Customer.enumDetailOfInvoice.ISPAID))));
        }
    }
}