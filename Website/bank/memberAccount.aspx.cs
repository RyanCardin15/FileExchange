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
    public partial class memberAccount : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string username = (string)Session["username"];
            transferFailedLabel.Visible = false;
            SqlConnection db = new SqlConnection(SqlDataSource1.ConnectionString);
            SqlCommand cmd = new SqlCommand("SELECT Member_Fname FROM BANK WHERE Member_Username = '" + username + "'", db);
            SqlCommand cmd1 = new SqlCommand("SELECT Member_CheckingTotal FROM BANK WHERE Member_Username = '" + username + "'", db);
            SqlCommand cmd2 = new SqlCommand("SELECT Member_SavingTotal FROM BANK WHERE Member_Username = '" + username + "'", db);

            
            db.Open();
            SqlDataReader rd = cmd.ExecuteReader();
            if (rd.Read())
            {
                //if read is successful load checking and savings totals into corresponding labels

                Label1.Text = rd.GetString(0);
                rd.Close();
                SqlDataReader rdc = cmd1.ExecuteReader();
                rdc.Read();
                decimal i = rdc.GetInt32(0);

                checkingLabel.Text = "$" + i.ToString();
                rdc.Close();

                SqlDataReader rds = cmd2.ExecuteReader();

                rds.Read();
                decimal x = rds.GetInt32(0);

                savingsLabel.Text = "$" + x.ToString();
                rds.Close();

                db.Close();

            }
            else
            {
                // invalidUserLabel.Visible = true;
            }


        }

        protected void transferButton_Click(object sender, EventArgs e)
        {
            string value1 = ToList.Text;
            string value2 = FromList.Text;
            decimal amount;
            decimal newBalanceChecking, newBalanceSaving;
            string username = (string)Session["username"];

            //convert value from amount box from string to decimal then perform transfer within
            if (Decimal.TryParse(AmountBox.Text, out amount))
            {
                //success

               

                //if both lists contain same account name display message to user
                if ((value1 == "SAVINGS" && value2 == "SAVINGS") || (value1 == "CHECKING" && value2 == "CHECKING"))
                {
                    transferFailedLabel.Visible = true;
                    transferFailedLabel.Text = "To and From accounts must be specified";
                }


                //transfer to checkings from savings
                if (value1 == "CHECKING" && value2 == "SAVINGS")
                {
                    SqlConnection db = new SqlConnection(SqlDataSource1.ConnectionString);
                    SqlCommand cmd1 = new SqlCommand("SELECT Member_CheckingTotal FROM BANK WHERE Member_Username = '" + username + "'", db);
                    SqlCommand cmd2 = new SqlCommand("SELECT Member_SavingTotal FROM BANK WHERE Member_Username = '" + username + "'", db);
                                                                   

                    
                    db.Open();
                    SqlDataReader rd = cmd1.ExecuteReader();
                    if (rd.Read())
                    {
                        //if read is successful load checking and savings totals into corresponding labels

                        // Label1.Text = rd.GetString(0);
                        //  rd.Close();
                        decimal checkingAmount = rd.GetInt32(0);
                        rd.Close();
                        SqlDataReader rds = cmd2.ExecuteReader();
                        rds.Read();
                        decimal savingsAmount = rds.GetInt32(0);


                        rds.Close();

                        if (amount > savingsAmount)
                        {
                            transferFailedLabel.Visible = true;
                            transferFailedLabel.Text = "Insufficient Funds";

                        }
                        else
                        {
                            newBalanceChecking = checkingAmount + amount;
                            newBalanceSaving = savingsAmount - amount;

                            SqlCommand cmd3 = new SqlCommand("UPDATE [BANK] SET Member_CheckingTotal = '" + newBalanceChecking + "'," + " Member_SavingTotal = '" + newBalanceSaving + "'  WHERE Member_Username = '" + username + "'", db);

                            try
                            {
                                cmd3.ExecuteNonQuery();
                            }
                            catch
                            {
                                transferFailedLabel.Visible = true;
                            }


                            checkingLabel.Text = "$" + newBalanceChecking.ToString();
                            savingsLabel.Text = "$" + newBalanceSaving.ToString();


                            db.Close();
                        }
                    }
                   

                }
                //transfer to savings from checking
                if (value1 == "SAVINGS" && value2 == "CHECKING")
                {
                    SqlConnection db = new SqlConnection(SqlDataSource1.ConnectionString);
                    SqlCommand cmd1 = new SqlCommand("SELECT Member_CheckingTotal FROM BANK WHERE Member_Username = '" + username + "'", db);
                    SqlCommand cmd2 = new SqlCommand("SELECT Member_SavingTotal FROM BANK WHERE Member_Username = '" + username + "'", db);

                    db.Open();
                    SqlDataReader rd = cmd1.ExecuteReader();
                    if (rd.Read())
                    {
                        //if read is successful load checking and savings totals into corresponding labels

                        decimal checkingAmount = rd.GetInt32(0);
                        rd.Close();
                        SqlDataReader rds = cmd2.ExecuteReader();
                        rds.Read();
                        decimal savingsAmount = rds.GetInt32(0);


                        rds.Close();

                        if (amount > checkingAmount)
                        {
                            transferFailedLabel.Visible = true;
                            transferFailedLabel.Text = "Insufficient Funds";

                        }
                        else { 

                        newBalanceChecking = checkingAmount - amount;
                        newBalanceSaving = savingsAmount + amount;
                        SqlCommand cmd3 = new SqlCommand("UPDATE [BANK] SET Member_CheckingTotal = '" + newBalanceChecking + "'," + " Member_SavingTotal = '" + newBalanceSaving + "'  WHERE Member_Username = '" + username + "'", db);

                        cmd3.ExecuteNonQuery();
                        checkingLabel.Text = "$" + newBalanceChecking.ToString();
                        savingsLabel.Text = "$" + newBalanceSaving.ToString();

                        db.Close();
                        }
                    }
                    

                }
              
            }
        }
    }
 }