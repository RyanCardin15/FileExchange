<%@ Page Language="C#" AutoEventWireup="true" UnobtrusiveValidationMode="none" CodeBehind ="adminPage.aspx.cs" Inherits="bank.adminPage" %>

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
        .auto-style2 {
            margin-left: 0px;
            margin-right: 0px;
        }
        </style>
</head>
<body>
    <form id="form1" runat="server">
    <ul class = "nav">
	<li><a href = "homePage.aspx">Signout</a></li>
	<li><a href = "about.aspx">About</a></li>
	<li><a href = "Careers.aspx">Careers</a></li>
	<li><a href = "contact.aspx">Contact</a></li>
		
  
  </ul>

        <div class="auto-style1" style="margin: 20px; padding: 50px; background-color: #FFFFFF; ">
            <asp:Label ID="Label1" runat="server" Font-Names="Century Gothic" Font-Size="XX-Large" ForeColor="#666666" Text="Welcome Admin!"></asp:Label>
            <br />
            <asp:Label ID="Label2" runat="server" Text="Users:" Font-Size="Large" ForeColor="#666666"></asp:Label>
            &nbsp;
            <br />
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataKeyNames="Member_ID" DataSourceID="SqlDataSource1" AllowPaging="True" AllowSorting="True" CssClass="auto-style2" ShowFooter="True" PageSize="5"  OnSelectedIndexChanged="GridView1_SelectedIndexChanged" Width="1218px">
                <Columns>
                    <asp:BoundField DataField="Member_ID" HeaderText="Member_ID" ReadOnly="True" SortExpression="Member_ID" />
                    <asp:BoundField DataField="Member_Username" HeaderText="Member_Username" SortExpression="Member_Username" />
                    <asp:BoundField DataField="Member_Password" HeaderText="Member_Password" SortExpression="Member_Password" />
                    <asp:BoundField DataField="Member_Fname" HeaderText="Member_Fname" SortExpression="Member_Fname" />
                    <asp:BoundField DataField="Member_Lname" HeaderText="Member_LName" SortExpression="Member_LName" />
                    <asp:BoundField DataField="Member_CheckingNum" HeaderText="Member_CheckingNum" SortExpression="Member_CheckingNum" />
                    <asp:BoundField DataField="Member_SavingsNum" HeaderText="Member_SavingsNum" SortExpression="Member_SavingsNum" />
                    <asp:BoundField DataField="Member_CheckingTotal" HeaderText="Member_CheckingTotal" SortExpression="Member_CheckingTotal" />
                    <asp:BoundField DataField="Member_SavingTotal" HeaderText="Member_SavingTotal" SortExpression="Member_SavingTotal" />
                </Columns>
                <PagerStyle CssClass="pagerStyle" HorizontalAlign="Center" />
            </asp:GridView>
            <asp:ValidationSummary ID="ValidationSummary1" ValidationGroup="INSERT" ForeColor="Red" runat="server" />
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:BankConnectionString2 %>" SelectCommand="SELECT * FROM [BANK]">
            </asp:SqlDataSource>
            <br />
            <br />
        </div>
    </form>

    </body>

</html>
