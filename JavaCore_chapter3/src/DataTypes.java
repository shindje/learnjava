
public class DataTypes {
	
	//int - 4 bytes = 4*32 = 4 billions / 2
	int i_min = -2_147_483_648;
	int i_max =  2_147_483_647;
	
	//short - 2 bytes = 2*16 = 64 000 / 2
	short s_min = -32_768;
	short s_max = 32_767;
	
	//long - 8 bytes = 2*64 = 9 223 372 036 854 775 808 * 2
	long l_min = -9_223_372_036_854_775_808L;
	long l_max = 9_223_372_036_854_775_807L;
	
	//byte - 1 byte = 2*8 = 256 /2
	byte b_min = -128;
	byte b_max = 127;
	
	int hexadecimal = 0xCAFE;
	int octal = 010;
	int binary = 0b0110_0101;
	
	//floating point
	
	//float 4 bytes - 6,7 decimal digits
	float f_min = -3.402_823_47E+38F; //approximately
	float f_max = 3.402_823_4733252563463454645645756756838683586324235362472675687648687E+38F; //approximately
	
	//double 8 bytes - 15 decimal digits
	double d_min = -1.797_693_134_862_315_7E+308D; //approximately
	double d_max = 1.797_693_134_862_315_7E+308;	//it's not necessary to use 'D'
	
	double d_hex = 0x1A.0p-3; // = (16+10) * 2^-3 = 0.125
	
	double d_const_min = -2/0.0; // = -2.0/0 != 2/0 NEGATIVE_INFINITY === Double.NEGATIVE_INFINITY
	double d_const_max = 5.0/0; //POSITIVE_INFINITY === Double.POSITIVE_INFINITY
	double d_const_zero = 0.0/0;// = sqrt(-5); // NaN === Double.NaN
	
	
	public static void main(String[] args) {
		DataTypes d = new DataTypes();
		System.out.println(d.d_hex);
		
		double dd= 0x1;
		System.out.println(dd);
		
		System.out.println(d.d_const_min);
		System.out.println(d.d_const_max);
		System.out.println(d.d_const_zero);
		System.out.println(Double.isNaN(d.d_const_zero));
	}
}
