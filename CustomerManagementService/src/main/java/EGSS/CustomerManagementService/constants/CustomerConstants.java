package EGSS.CustomerManagementService.constants;

public class CustomerConstants {
	
	public static String ADDTOCUSTOMER = "insert  into  customer(id,firstName,lastName,NIC,email,Street,state,postalCode,status,createdBy,createdDate,modifiedBy,modifiedDate) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static String VIEWCUSTOMER = "select firstName, lastName,NIC,email,Street, state, postalCode * from customer";
    public static String GETONECUSTOMER ="select * from customer where id=?";
    public static String UPDATECUSTOMER ="update customer set firstName= ?,lastName=?,NIC=?,email=?,Street=?,state=?,postalCode=?,status=? where id=?";
    public static String DELETECUSTOMER = "delete from customer where id=?";
    public static String GETAUTHDETAILS ="select id,role from customer order by id desc limit 1 ";
    public static String INSERTAUTHDATA ="insert into user(uId,id,role,password)values(?,?,?,?)";
    public static String LOGUSER = "select c.email,u.password,u.role from user u , customer c where c.email=? and u.password=?";
    
    public static int INDEX_ONE  =  1;
	public static int INDEX_TWO  =  2;
	public static int INDEX_TREE = 3;
	public static int INDEX_FOUR = 4;
	public static int INDEX_FIVE = 5;
	public static int INDEX_SIX = 6;
	public static int INDEX_SEVEN = 7;
	public static int INDEX_EIGHT = 8;
	public static int INDEX_NINE = 9;
	public static int INDEX_TEN = 10;
	public static int INDEX_ELEVEN = 11;
	public static int INDEX_TWELEVE = 12;
	public static int INDEX_THIRTEEN = 13;

}
