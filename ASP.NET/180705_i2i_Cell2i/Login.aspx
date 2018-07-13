<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="_180705_i2i_Cell2i.Login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>
        Cell2i
    </title>
</head>
<body style="height: 600px; width: 1477px; margin-left: 0px; margin-top: 50px;">
    <form id="form1" runat="server">
        <div style="height: 65px; width: 1076px; margin-left: 0px;" draggable="auto">
            <asp:Image ID="img_i2i" runat="server" Height="60px" ImageUrl="~/icons/i2i_logo.png" style="margin-left: 72px; margin-top: 14px" Width="226px" />
            <hr style="margin-top: 19px; color: #C0CDCD; font-family: Arial, Helvetica, sans-serif; height: -27px; width: 1407px; margin-left: 31px;" draggable="auto" />
        </div>
        <div style="height: 450px; width: 641px; margin-left: 456px; margin-top: 65px"  aria-expanded="undefined" aria-orientation="horizontal" draggable="auto">
            
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <asp:Image ID="img_cel2i" runat="server" Height="158px" ImageUrl="~/icons/cell2i-original[780].png" Width="318px" />
            <br />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:TextBox ID="txt_phoneNumber" runat="server" Height="26px" style="margin-left: 12px; margin-top: 66px; margin-bottom: 0px" Width="319px" placeholder="Enter your phone number" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;" MaxLength="10" ></asp:TextBox>
            <br />
            <br />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:TextBox ID="txt_password" runat="server" Height="26px" style="margin-left: 14px; margin-top: 2px" Width="315px" placeholder="Enter your password" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;" TextMode="Password" MaxLength="60"></asp:TextBox>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
            <br />
            &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
                <asp:HyperLink ID="hypl_forgotpassword" runat="server" Font-Bold="True" Font-Names="Segoe UI" Font-Size="Small" NavigateUrl="~/ForgotPassword.aspx" ForeColor="#1E7CC0">Forgot your password?</asp:HyperLink>
            <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <asp:Label ID="lbl_invalid" runat="server" Font-Bold="False" Font-Names="Segoe UI" ForeColor="#F93324" Text="Invalid  login" Visible="False"></asp:Label>
            <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Label ID="lbl_check" runat="server" Font-Names="Segoe UI" ForeColor="#F93324" Text="Please check your phone number and password then try again." Visible="False"></asp:Label>
            <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="btn_login" runat="server" BackColor="#1e7cc0" ForeColor="White"  style="margin-left: 57px; margin-top: 33px;" Text="LOGIN" Width="116px" OnClick="btn_login_Click" Height="29px" Font-Names="Segoe UI" />
            <br />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <br />
            
        </div>
    </form>
</body>
</html>
