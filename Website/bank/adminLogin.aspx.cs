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
    public partial class adminLogin : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            invalidUserLabel.Visible = false;
        }

        protected void adminButton_Click(object sender, EventArgs e)
        {
            Response.Redirect("/homePage.aspx");
                
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            string value1 = usernameBox.Text;
            string value2 = passwordBox.Text;

            SqlConnection db = new SqlConnection(SqlDataSource1.ConnectionString);
            SqlCommand cmd = new SqlCommand("SELECT * FROM ADMIN WHERE Admin_AdminUsername = '" + value1 + "'AND Admin_AdminPassword = '" + value2 + "'", db);

            db.Open();
            SqlDataReader rd = cmd.ExecuteReader();

            if (rd.Read())
            {
                Session["username"] = usernameBox.Text;

                Response.Redirect("/adminPage.aspx");
            }
            else
            {
                invalidUserLabel.Visible = true;
            }
        }
    }
}