<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ForgotPassword.aspx.cs" Inherits="_180705_i2i_Cell2i.ForgotPassword" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            margin-left: 424px;
        }
    </style>
</head>
<body style="height: 624px; width: 1477px; margin-left: 0px; margin-top: 50px;">
    <form id="form1" runat="server">
        <div style="height: 65px; width: 1076px; margin-left: 0px;" draggable="auto">
            <asp:Image ID="img_i2i" runat="server" Height="60px" ImageUrl="~/icons/i2i_logo.png" style="margin-left: 72px; margin-top: 14px" Width="226px" />
            <hr style="margin-top: 19px; color: #C0CDCD; font-family: Arial, Helvetica, sans-serif; height: -27px; width: 1407px; margin-left: 31px;" draggable="auto" />
</div>
        <div style="height: 593px; width: 724px; margin-left: 424px; margin-top: 65px"  aria-expanded="undefined" aria-orientation="horizontal" draggable="auto" class="auto-style1">
            
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <asp:Image ID="img_cel2i" runat="server" Height="158px" ImageUrl="~/icons/cell2i-original[780].png" Width="318px" />
            <br />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:TextBox ID="txt_enterPhoneNumber" runat="server" Height="26px" style="margin-left: 12px; margin-top: 66px; margin-bottom: 0px" Width="319px" placeholder="Enter your phone number" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;" MaxLength="10"></asp:TextBox>
            <br />
            <br />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:TextBox ID="txt_enterNewPassword" runat="server" Height="26px" style="margin-left: 14px; margin-top: 2px" Width="315px" placeholder="Enter your password" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;" TextMode="Password" MaxLength="60"></asp:TextBox>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
            <br />
            <br />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:TextBox ID="txt_confirmPassword" runat="server" Height="26px" style="margin-left: 14px; margin-top: 2px" Width="315px" placeholder="Confirm your password" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;" TextMode="Password" MaxLength="60"></asp:TextBox>
            &nbsp;&nbsp;&nbsp;
            <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <br />
            &nbsp;&nbsp;&nbsp;
            <asp:Label ID="lbl_statusChangePassword" runat="server" style="text-align:center" Font-Bold="False" Font-Names="Segoe UI" ForeColor="#F93324" Text=" Your password should be 8 character long and should contain at least one special character and number" Visible="False" Width="530px"></asp:Label>
            <br />
            
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="btn_change" runat="server" BackColor="#1E7CC0" ForeColor="White"  style="margin-left: 57px; margin-top: 33px;" Text="DONE" Width="116px" OnClick="btn_change_Click" Height="29px" Font-Names="Segoe UI" />
            
        </div>
    </form>
</body>
</html>
