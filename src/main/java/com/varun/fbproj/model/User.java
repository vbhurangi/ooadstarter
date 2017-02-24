package com.varun.fbproj.model;

import java.util.Date;

public class User {

	    private int userID;
		private String emailID;
		private String password;
		private String fname;
		private String lname;
		private Date dob;  //this date we are not using i think
		private String date;
		private String pic;
		private String mob_no;
		private String town;
		private String college;
		
		public User()
		{
			
		}


		public User(int userID,String emailID,String password,
				String fname,String lname,Date dob,String date,String pic,
				String mob_no,String town,String college
				) {
			super();
			this.userID=userID;
			this.emailID = emailID;
			this.password = password;
			this.fname = fname;
			this.lname=lname;
			this.dob = dob;
			this.date=date;
			this.pic = pic;
			this.mob_no=mob_no;
			this.town = town;
			this.college=college;
			
		}


		public int getUserID() {
			return userID;
		}


		public void setUserID(int userID) {
			this.userID = userID;
		}


		public String getEmailID() {
			return emailID;
		}


		public void setEmailID(String emailID) {
			this.emailID = emailID;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getFname() {
			return fname;
		}


		public void setFname(String fname) {
			this.fname = fname;
		}


		public String getLname() {
			return lname;
		}


		public void setLname(String lname) {
			this.lname = lname;
		}


		public Date getDob() {
			return dob;
		}


		public void setDob(Date dob) {
			this.dob = dob;
		}


		public String getDate() {
			return date;
		}


		public void setDate(String date) {
			this.date = date;
		}


		public String getPic() {
			return pic;
		}


		public void setPic(String pic) {
			this.pic = pic;
		}


		public String getMob_no() {
			return mob_no;
		}


		public void setMob_no(String mob_no) {
			this.mob_no = mob_no;
		}


		public String getTown() {
			return town;
		}


		public void setTown(String town) {
			this.town = town;
		}


		public String getCollege() {
			return college;
		}


		public void setCollege(String college) {
			this.college = college;
		}


	
}//class ends here
