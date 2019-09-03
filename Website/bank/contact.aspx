<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="contact.aspx.cs" Inherits="bank.contact" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta charset="utf-8"/>

   <meta name="viewport" content="width=device-width, initial-scale=1"/>

   <link rel="stylesheet" href="/Content/bootstrap.min.css"  runat="server"/>

   <script src="bootstrap.min.js"></script>

   
    <title>The Bank</title>
    <style type="text/css">
        .auto-style1 {
            width: auto;
            height: 376px;
            margin-left: 67px;
        }
        </style>
</head>
<body>
    <form id="form1" runat="server">
    <ul class = "nav">
	<li><a href = "homePage.aspx">Home</a></li>
	<li><a href = "about.aspx">About</a></li>
	<li><a href = "Careers.aspx">Careers</a></li>
	<li><a href = "contact.aspx">Contact</a></li>
		
  
  </ul>

        <div class="auto-style1" style="margin: 20px; padding: 50px; background-color: #FFFFFF; ">
            <asp:Label ID="Label1" runat="server" Font-Names="Century Gothic" Font-Size="XX-Large" ForeColor="#666666" Text="Contact"></asp:Label>
            <br />
            <asp:Label ID="Label2" runat="server" Text="Customer service representatives are standing by! " Font-Size="Large" ForeColor="#666666"></asp:Label>
            &nbsp;
            <br />
            <asp:Label ID="Label3" runat="server" Text="Call us 24/7: 1-800-959-3611 " Font-Size="Large" ForeColor="#666666"></asp:Label>
            <br />
            <asp:Label ID="Label4" runat="server" Text="Visit us on  " Font-Size="Large" ForeColor="#666666"></asp:Label>
            <asp:LinkButton ID="LinkButton1" runat="server">FaceBook</asp:LinkButton>
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
        </div>
    </form>

    </body>
</html>
