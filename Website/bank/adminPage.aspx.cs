using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.Sql;
using System.Data.SqlClient;
namespace bank
{
    public partial class adminPage : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
          





        }

        protected void lbInsert_Click(object sender, EventArgs e) { 

         // SqlDataSource1.InsertParameters["Member_UserID"].DefaultValue = ((TextBox) GridView1.FooterRow.FindControl("UsernameInsert")).Text;

           SqlDataSource1.InsertParameters["Member_UserName"].DefaultValue = ((TextBox)GridView1.FooterRow.FindControl("UsernameInsert")).Text;
           SqlDataSource1.InsertParameters["Member_Password"].DefaultValue = ((TextBox)GridView1.FooterRow.FindControl("PasswordInsert")).Text;
            SqlDataSource1.InsertParameters["Member_Fname"].DefaultValue = ((TextBox)GridView1.FooterRow.FindControl("FnameInsert")).Text;
            SqlDataSource1.InsertParameters["Member_Lname"].DefaultValue = ((TextBox)GridView1.FooterRow.FindControl("LnameInsert")).Text;
            SqlDataSource1.InsertParameters["Member_CheckingNum"].DefaultValue = ((TextBox)GridView1.FooterRow.FindControl("checkNumInsert")).Text;

            SqlDataSource1.InsertParameters["Member_SavingsNum"].DefaultValue = ((TextBox)GridView1.FooterRow.FindControl("savingsNumInsert")).Text;
            SqlDataSource1.InsertParameters["Member_CheckingTotal"].DefaultValue = ((TextBox)GridView1.FooterRow.FindControl("checkingTotalInsert")).Text;
            SqlDataSource1.InsertParameters["Member_SavingTotal"].DefaultValue = ((TextBox)GridView1.FooterRow.FindControl("savingsTotalInsert")).Text;

           SqlDataSource1.Insert();


        }

          
        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}