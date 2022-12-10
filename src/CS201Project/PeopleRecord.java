package CS201Project;

//import java.lang.reflect.Constructor;
//import java.lang.reflect.Field;

class PeopleRecord {
	private String givenName;
	private String famName;
	private String companyName;
	private String address;
	private String city;
	private String county;
	private String state;
	private String zip;
	private String phone1;
	private String phone2;
	private String email;
	private String web;
	private String birthday;
	
	public PeopleRecord(String givenName, String famName, String companyName,
						String adress, String city, String county,
						String state, String zip, String phone1,
						String phone2, String email, String web,
						String birthday)
	{
		this.givenName = givenName; this.famName = famName; this.companyName = companyName;
		this.address = adress; this.city = city; this.county = county;
		this.state = state; this.zip = zip; this.phone1 = phone1;
		this.phone2 = phone2; this.email= email; this.web = web;
		this.birthday = birthday;
	}
	
	// setters and getters for the attributes above
	public String getGivenName() {
	        return givenName;
	 }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return famName;
    }

    public void setFamilyName(String familyName) {
        this.famName = familyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    // method to compare two record depending on all attributes
    // worst case is all attributes are equal
    //TODO: optimized way?
   /* public int compareTo_recursive(PeopleRecord that,Field[] fieldsOfClass,int fieldsIterator)
    {

        if (fieldsIterator==fieldsOfClass.length)
        {
            return 0;
        }
        try{
            Class fieldType=fieldsOfClass[fieldsIterator].getType();
            Class[] interfaces=fieldType.getInterfaces();

            for (Class i:interfaces){
                if (i.getName()=="java.lang.Comparable"||i.isPrimitive()){


                    if (fieldType.cast(fieldsOfClass[fieldsIterator].get(this)).compareTo(fieldType.cast(fieldsOfClass[fieldsIterator].get(that)))>0)
                    {
                        return 1;
                    }
                    if (fieldType.cast(fieldsOfClass[fieldsIterator].get(this)).compareTo(fieldType.cast(fieldsOfClass[fieldsIterator].get(that)))<0)
                    {
                        return -1;
                    }
                    return compareTo_recursive(that,fieldsOfClass,fieldsIterator+1);
                }
            }

        }
        catch(Exception e)
        {

        }

        return compareTo_recursive(that,fieldsOfClass,fieldsIterator+1);
    }*/
    public int compareTo(PeopleRecord that) {
    	int result = this.givenName.compareTo(that.givenName);
    	if(result == 0) {
    		result = this.famName.compareTo(that.famName);
    		if(result == 0) {
				result = this.companyName.compareTo(that.companyName);
				if(result == 0) {
					result = this.address.compareTo(that.address);
					if(result == 0) {
						result = this.city.compareTo(that.city);
						if(result == 0) {
							result = this.county.compareTo(that.county);
							if(result == 0) {
								result = this.state.compareTo(that.state);
								if(result == 0) {
									result = this.zip.compareTo(that.zip);
									if(result == 0) {
										result =this.phone1.compareTo(phone1);
										if(result == 0) {
											result =this.phone2.compareTo(phone2);
											if(result == 0) {
												result = this.email.compareTo(that.email);
												if(result == 0) {
													result = this.web.compareTo(that.web);
														if(result == 0) {
															result = this.birthday.compareTo(that.birthday);
															if(result == 0) {
																// in this case all attributes are equal
																// meaning this entry already exists
																System.out.println("[INFO]: Record already exists");
    														}
    													}
    												}
    											}
    										}
    									}
    								}
    							}
    						}
    					}
    				}
    			}
    		}
    	return result;
        //Field[] fieldsOfPeopleRecord = this.getClass().getFields();
        //return compareTo_recursive(that,fieldsOfPeopleRecord,0);
    }
    
}
