<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="homePage.aspx.cs" UnobtrusiveValidationMode="none" Inherits="bank.homePage" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta charset="utf-8"/>

   <meta name="viewport" content="width=device-width, initial-scale=1"/>

   

   
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
   <link rel="stylesheet" href="/css/main.css" />

</head>
<body>
    <form id="form1" runat="server">

    <center>
    <nav class="navbar nav-graphite">
	<a href = "homePage.aspx">Home</a>
	<a href = "about.aspx">About</a>
	<a href = "Careers.aspx">Careers</a>
	<a href = "contact.aspx">Contact</a>
    <asp:LinkButton ID="adminButton" runat="server" CausesValidation="False" OnClick="adminButton_Click">Admin</asp:LinkButton>
    </nav>
    </center>

        
        <div class="space jumbotron-fluid text-centered blue">
        <div background-color: rgba(10, 90, 143, 0.80); ">
            <h1>The Bank</h1>
            <br />
            <h6>The Bank is the best place for all your online banking needs. Our representatives are standing by to assist you every step of the way! Please login to access and manage your account today!</h6>
           <div class="container">
               <div class="row">
                    <p>Username: </p>
                    <asp:TextBox ID="usernameBox" runat="server" BorderStyle="Ridge" Font-Names="Arial" ForeColor="#666666" height="50%"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="usernameValidator1" runat="server" ControlToValidate="usernameBox" Display="Dynamic" ErrorMessage="RequiredFieldValidator">*username is required</asp:RequiredFieldValidator>
                    <asp:Label ID="invalidUserLabel" runat="server" ForeColor="Red" Text="*Invalid username/password"></asp:Label>
                </div>
                <br />
                <div class="row">
                    <p>Password: </p>
                    <asp:TextBox ID="passwordBox" runat="server" BorderStyle="Ridge" ForeColor="#666666" TextMode="Password" height="50%"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="psswordValidator" runat="server" ControlToValidate="passwordBox" ErrorMessage="RequiredFieldValidator" Display="Dynamic">*password is required</asp:RequiredFieldValidator>
                </div>
                <div class="row">
                    <asp:Button ID="Button1" runat="server" style="padding-left: 10px;" BackColor="#16181b" ForeColor="White" Font-Names="Arial" OnClick="Button1_Click" Text="login" height="50%" />
                </div>
            </div>
            <br />
            <br />
            <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:BankConnectionString2 %>" SelectCommand="SELECT * FROM [BANK]"></asp:SqlDataSource>
        </div>
        </div>
    </form>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
