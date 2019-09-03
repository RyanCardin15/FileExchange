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
    public partial class homePage : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            invalidUserLabel.Visible = false;
           
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            string value1 = usernameBox.Text;
            string value2 = passwordBox.Text;

            SqlConnection db = new SqlConnection(SqlDataSource1.ConnectionString);
            SqlCommand cmd = new SqlCommand("SELECT * FROM BANK WHERE Member_Username = '" + value1 + "'AND Member_Password = '" + value2 +"'", db);

            db.Open();
            SqlDataReader rd = cmd.ExecuteReader();

            if (rd.Read())
            {
                Session["username"] = usernameBox.Text;
                
                Response.Redirect("/memberAccount.aspx");
              
            }
            else
            {
                invalidUserLabel.Visible = true;
            }
        }

        protected void adminButton_Click(object sender, EventArgs e)
        {
            Response.Redirect("/adminLogin.aspx");


            

        }

        
    }
}