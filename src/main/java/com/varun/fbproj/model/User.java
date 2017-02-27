package com.varun.fbproj.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

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
		
		private String user_token;
		
		public User()
		{
			
		}


		public User(int userID,String emailID,String password,
				String fname,String lname,Date dob,String date,String pic,
				String mob_no,String town,String college,String user_token
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
			this.user_token=user_token;
		}

		@JsonProperty(value = "userID")
		public int getUserID() {
			return userID;
		}


		public void setUserID(int userID) {
			this.userID = userID;
		}

		@JsonProperty(value = "emailID")
		public String getEmailID() {
			return emailID;
		}


		public void setEmailID(String emailID) {
			this.emailID = emailID;
		}

		@JsonProperty(value = "password")
		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}

		@JsonProperty(value = "fname")
		public String getFname() {
			return fname;
		}


		public void setFname(String fname) {
			this.fname = fname;
		}

		@JsonProperty(value = "lname")
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

		@JsonProperty(value = "date")
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

		@JsonProperty(value = "mob_no")
		public String getMob_no() {
			return mob_no;
		}


		public void setMob_no(String mob_no) {
			this.mob_no = mob_no;
		}

		@JsonProperty(value = "town")
		public String getTown() {
			return town;
		}


		public void setTown(String town) {
			this.town = town;
		}

		@JsonProperty(value = "college")
		public String getCollege() {
			return college;
		}


		public void setCollege(String college) {
			this.college = college;
		}


		public String getUser_token() {
			return user_token;
		}


		public void setUser_token(String user_token) {
			this.user_token = user_token;
		}


	
}//class ends here
