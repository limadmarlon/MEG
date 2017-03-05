package lexical;

public enum tkCateg {
	tkMain(1),
	tkId(2),
	tkOpr_sum(3),
	tkOpr_mul(4),
	tkOpr_inv(5),
	tkOpr_log(6),
	tkOpr_att(7),
	tkOpr_r(8),
	tkOpr_concat(9),
	tkOpr_index_enter(10),
	tkOpr_index_out(11), 
	tkDel_par_enter(12),
	tkDel_par_out(13),
	tkDel_bra_enter(14),
	tkDel_bra_out(15),
	tkDel_comB_enter(16),
	tkDel_comB_out(17),
	tkDel_comL(18),
	tkDel_scolon(19), 
	tkDel_colon(20), 
	tkDel_dot(21), 
	tkDel_comma(22),
	tkDel_quoteS(23), 
	tkDel_quoteD(24), 
	tkType_int(25), 
	tkType_float(26),
	tkType_char(27), 
	tkType_bool(28), 
	tkType_string(29), 
	tkType_array(30),
	tkLit_int(31), 
	tkLit_float(32), 
	tkLit_char(33), 
	tkLit_bool(34),
	tkLit_string(35), 
	tkLit_array(36),
	tk_end(37), 
	tk_return(38), 
	tk_if(39),
	tk_then(40), 
	tk_else(41), 
	tk_while(42), 
	tk_do(43), 
	tk_for(44), 
	tk_in(45), 
	tk_out(46);
	
	private int value;
	
	private tkCateg(int value) {
		this.value = value;
	}
	
	public int getCategValue() {
		return value;
	}
}
