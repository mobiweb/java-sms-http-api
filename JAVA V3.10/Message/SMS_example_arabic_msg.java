/*
.---------------------------------------------------------------------------.
|  Software: 	SMS - Send SMS Example: Arabic Text SMS						|
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
* Arabic Text SMS
* @copyright 1999 - 2014 Mobiweb Ltd.
*
*/

package Message;

public class SMS_example_arabic_msg {
    public static void main(String [ ] args){
        SMS sol4mob_sms         =   new SMS();              						// Create SMS object.
        sol4mob_sms.send_url    =   "http://IPADDRESS/send_script";   				// The HTTP request URL used for messaging 
        sol4mob_sms.username    =   "username"; 					  				// The HTTP API username of your account.
        sol4mob_sms.password    =   "password";             						// The HTTP API password of your account.
        sol4mob_sms.msgtext     =   "063506280627062D002006270644062E064A0631";     // SMS Message text 'Good Morning' in Arabic.
        sol4mob_sms.originator  =   "TestAccount";          						// The desired Originator of your message.
        sol4mob_sms.phone       =   "recipient";        	  						// The full International mobile number of the
                                                            						// recipient excluding the leeding +.
        sol4mob_sms.charset     =   6;                      						// Charset required for Arabic text.
        String ret              =   sol4mob_sms.send();     						// Call method send() to send SMS Message.
        System.out.println(ret);
    }
}
