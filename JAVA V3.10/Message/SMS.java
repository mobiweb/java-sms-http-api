/*
.---------------------------------------------------------------------------.
|  Software: 	SMS - HTTP API BULK SMS Messaging class     	            |
|  Version: 	3.10														|
|  Email: 		sales@solutions4mobiles.com									|
|  Info: 		http://www.solutions4mobiles.com							|
|  Phone:		+44 203 318 3618											|
| ------------------------------------------------------------------------- |
| Copyright (c) 1999-2014, Mobiweb Ltd. All Rights Reserved.                |
| ------------------------------------------------------------------------- |
| LICENSE:																	|
| Distributed under the General Public License v3 (GPLv3)					|
| http://www.gnu.org/licenses/gpl-3.0.html									|
| This program is distributed AS IS and in the hope that it will be useful	|
| WITHOUT ANY WARRANTY; without even the implied warranty of				|
| MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.                      |
| ------------------------------------------------------------------------- |
| SERVICES:																	|
| We offer a number of paid services at http//www.solutions4mobiles.com:    |
| - Bulk SMS / MMS / Premium SMS Services / HLR Lookup Service				|
| ------------------------------------------------------------------------- |
| HELP:																		|
| - This class requires a valid HTTP API Account. Please email to			|
| sales@solutions4mobiles.com to get one									|
'---------------------------------------------------------------------------'

/**
 * SMS - HTTP API BULK SMS Messaging class
 * @copyright 1999 - 2014 Mobiweb Ltd.
 */

package Message;
import java.net.URL;
import java.net.URLConnection;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SMS {

    //---------------------------------
    // PROPERTIES
    //---------------------------------

    /**
    * The HTTP API username that is supplied to your account
    * (most of the times it is your email)
    * String
    */
    public String username      =   "username";

    /**
    * The HTTP API password of your account
    * String
    */
    public String password      =   "password";

    /**
    * The HTTP API provider of your account
    * String
    */
    public String provider	=   "solutions4mobiles.com";

    /**
    * The HTTP request URL used for account balance information.
    * (Use it to get the remaining credits to your account)
    * String
    */
    public String balance_url	=   "http://IPADDRESS/balance_script";

    /**
    * The HTTP request URL used for messaging
    * (Use it to send SMS)
    * String
    */
    public String send_url      =   "http://IPADDRESS/send_script";

    /**
    * The SMS charset
    * Int [OPTIONAL] -> Default is 0.
    */
    public int charset          =   0;

    /**
    * The SMS message text
    * String
    */
    public String msgtext       =   "Hello World";

    /**
    * The originator of your message (11 alphanumeric or 14 numeric values).
    * Valid Chars are: A-z,0-9 (no Spaces or other chars like $-+!).
    * String
    */
    public String originator	=   "TestAccount";

    /**
    * The full International mobile number of the recipient excluding
    * the leeding + (e.g. 33xxxxxxxxxx for France, 4478xxxxxx for UK etc)
    * To send to multiple recipients, separate each number with a comma
    * (e.g. 44xxxxx,33xxxxxx,20xxxxxx).
    * Please note that no blanks can be used.
    * String
    */
    public String phone         =   "recipient";

    /**
    * Request Delivery Report.
    * If set to 1 a unique id for requesting delivery report of this SMS
    * is returned with the OK return value upon sending.
    * Int [OPTIONAL] -> Default is 0 (No DLR).
    */
    public int showDLR		=   0;

    /**
    * The SMS message type.
    * If set to F the SMS is sent as Flash.
    * String [OPTIONAL] -> Default is empty (GSM text message).
    */
    public String msgtype       =   "";

    /**
    * Adjust Delivery date to UTC time. (acceptable values: …-11…+11).
    * Int [OPTIONAL] -> Default is 0 (UTC 0).
    */
    public int utc              =   0;

    //---------------------------------
    // METHODS
    //---------------------------------

    /**
    * This method sends out one SMS message or multiple (for multiple recipients).
    * Parameters:
    * 	none. (NOTE: SMS object must be correctly initialized in order for this method to work.)
    * Returns:
    * 	OK			Successfully Sent
    * 	ERROR100	Temporary Internal Server Error. Try again later
    *	ERROR101	Authentication Error (Not valid login Information)
    *	ERROR102	No credits available
    *	ERROR103	MSIDSN (phone parameter) is invalid or prefix is not supported
    *	ERROR104	Tariff Error
    *	ERROR105	You are not allowed to send to that destination/country
    *	ERROR106	Not Valid Route number or you are not allowed to use this route
    *	ERROR107	No proper Authentication (IP restriction is activated)
    *	ERROR108	You have no permission to send messages through HTTP API
    *	ERROR109	Not Valid Originator
    *	ERROR999	Invalid HTTP Request
    * 	if showDLR is set to 1 a unique id for the delivery report of this SMS is returned with the OK return value.
    */

    public String send(){
        String fieldstring = "username="+this.username+"&password="+this.password + "&charset=" +this.charset+"&msgtext="+this.msgtext+"&originator="+this.originator+"&phone="+this.phone+"&provider="+this.provider+"&showDLR="+this.showDLR+"&msgtype="+this.msgtype;
        String res="";
        try{
            URL url = new URL(this.send_url);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(fieldstring);
            wr.flush();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                res=res+line;
            }
            wr.close();
            rd.close();

        }catch(Exception e){

        }
        return res;
    }

    /**
    * This method gets the balance of a HTTP API account.
    * Parameters:
    * 	none. (NOTE: SMS object must be correctly initialized in order for this method to work.)
    * Returns:
    * 	Account balance in EUROS
    */

    public String getBalance(){
        String fieldstring = "username="+this.username+"&password="+this.password+"&provider="+this.provider;
        String res="";
        try{
            URL url = new URL(this.balance_url);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(fieldstring);
            wr.flush();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                res=res+line;
            }
            wr.close();
            rd.close();

        }catch(Exception e){

        }
        return res;
    }
}
