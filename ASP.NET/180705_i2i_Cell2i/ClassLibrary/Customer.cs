using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace _180705_i2i_Cell2i
{
    public class Customer
    {
        string phoneNumber;
        string password;
        string fullname;
        //string tariff;
        public static WebServiceReferenceV_2.Cell2iWebServiceImplClient client2 = new WebServiceReferenceV_2.Cell2iWebServiceImplClient();
        public string[] tariffInfoList;
        //protected static string[] usageInfoList;
        public string[] usageSMSInfoList;
        public string[] usageCallInfoList;
        public string[] usageInternetInfoList;
        public static List<List<String>> invoices = new List<List<string>>();
        public enum enumDetailOfInvoice {STARTDATE,ENDDATE,COST,ISPAID };
        public enum enumOrderOfMonths { MONTH_1,MONTH_2,MONTH_3,MONTH_4, MONTH_5, MONTH_6};




        public Customer(string phoneNumber, string password)
        {
            this.phoneNumber = phoneNumber;
            this.password = password;
        }
        public Customer(string phoneNumber, string password, string fullname)
        {
            this.phoneNumber = phoneNumber;
            this.password = password;
            this.fullname = fullname;
            //tariffInfoToList();
            //usageInfoToListSMS();
            //usageInfoToListCall();
            //usageInfoToListInternet();

        }

        public void setPhoneNumber(string phoneNumber)
        {
            this.phoneNumber = phoneNumber;
        }


        public string getPhoneNumber()
        {
            return phoneNumber;        
        }

        public void setPassword(string password)
        {
            this.password = password;
        }
        public string getPassword()
        {
            return password;
        }

        public string getFullname()
        {
            string info = client2.getUserInfo(getPhoneNumber());
            string[] fullname;
            fullname = info.Split('_');
            return fullname[1] + " " + fullname[2];           //change when web service ready   return client2.getUserInfo(customer.getPhoneNumber());   
        }

        //public string getTariff(Customer customer)
        //{
        //    return "erdem";          //change when web service ready
        //}


        public Boolean isAuthenticated()
        {
            
               try
               {

                   if (client2.isConnected() == "Connect Successful")
                   {
                       if (client2.isAuthorized(this.phoneNumber, this.password))
                       {
                           return true;
                       }
                       else
                       {
                           return false;
                       }
                   }
                   else
                   {
                       return false;
                   }
               }
               catch (Exception e)
               {
                   System.Console.WriteLine(e);
                   return false;
               }
            
            

        }
        public void tariffInfoToList()
        {
            string info = client2.getTariffInfo(getPhoneNumber());
            tariffInfoList = info.Split('_');
            
        }

        public string tariffName()
        {
            return tariffInfoList[0];
        }

        public string getCallLimit()
        {
            return tariffInfoList[1];
        }

        public string getSMSLimit()
        {
            return tariffInfoList[2];
        }

        public string getInternetLimit()
        {
            return tariffInfoList[3];
        }
        //public string getUsageSMS()
        //{
        //    string info = client2.getUsageInfo(getPhoneNumber(), "SMS");
        //    return info;
        //}
        //public string getUsageI

        public void usageInfoToListSMS()
        {
            string info = client2.getUsageInfo(getPhoneNumber(),"SMS");
            usageSMSInfoList = info.Split('_');

        }
        public string getSMSUsage()
        {
            return usageSMSInfoList[1];
        }

        public string getSMSUsageDate()
        {
            return usageSMSInfoList[2];
        }
        public void usageInfoToListCall()
        {
            string info = client2.getUsageInfo(getPhoneNumber(), "VOICE");
            usageCallInfoList = info.Split('_');

        }
        public string getCallUsage()
        {
            return usageCallInfoList[1];
        }

        public string getCallUsageDate()
        {
            return usageCallInfoList[2];
        }
        public void usageInfoToListInternet()
        {
            string info = client2.getUsageInfo(getPhoneNumber(), "DATA");
            usageInternetInfoList = info.Split('_');

        }
        public string getInternetUsage()
        {
            return usageInternetInfoList[1];
        }

        public string getInternetUsageDate()
        {
            return usageInternetInfoList[2];
        }
        public List<List<String>> getSplittedInvoiceDetail()
        {
            string info=client2.getInvoiceInfo(getPhoneNumber(), 6);

            foreach (string invoice in info.Split('@'))
            {
                List<String> oneRowInvoice = new List<String>();
                foreach (string elementInvoice in invoice.Split('_'))
                {
                    oneRowInvoice.Add(elementInvoice);
                }
                invoices.Add(oneRowInvoice);
            }
            return invoices;
        }
        //public string getIndexedInvoiceDetail()
        //{
        //    return "erdem";
        //}
        public string getMonthOfInvoice(int OrderOfMonths)
        {
            //getMagicalInvoiceData(OrderOfMonths, 1);
            DateTime selectedDate = DateTime.ParseExact(getMagicalInvoiceData(OrderOfMonths, 1), "dd.MM.yyyy", System.Globalization.CultureInfo.InvariantCulture);
            return selectedDate.ToString("MMMM"); 
        }
        public string getMagicalInvoiceData(int OrderOfMonths, int DetailOfInvoice)
        {
            getSplittedInvoiceDetail();
            return invoices[OrderOfMonths][DetailOfInvoice];
        }

        public string paidOrNotPaid(int candidateValue)
        {
            Boolean ispaid=Convert.ToBoolean(candidateValue);
            return ispaid ? "PAID" : "NOT PAID";
        }


    }
}