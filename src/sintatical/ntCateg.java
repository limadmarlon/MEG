package sintatical;

public enum ntCateg {
	ntCode(51),
	ntCoder(52),
	ntDecl_Main(53),
	ntMain_function(54),
	ntMain_process(55),
	ntFunCall(56),
	ntFunCallr(57),
	ntFunCallParam(58),
	ntFunCallParamr(59),
	ntDecl(60),
	ntArrayType(61),
	ntType(62),
	ntDecl_param_list(63),
	ntStatements_return(64),
	ntStatements_return_op(65),
	ntStatements_main(66),
	ntStatement(67),
	ntExp_log(68),
	ntExp_logr(69),
	ntExp_log2(70),
	ntvalue_log(71),
	ntExp_rel(72),
	ntExp_relr(73),
	ntExp_aritm(74),
	ntExp_aritmr(75),
	ntExp_aritm2(76),
	ntExp_aritm2r(77),
	ntExp_aritm3(78),
	ntExp_aritm4(79),
	ntExp_Paren_Cast(80),
	ntvalue_aritm(81),
	ntDiffer2(82),
	ntCC(83),
	ntIndex(84),
	ntATT(85),
	ntATTr(86),
	ntCast(87),
	ntCastParam(88),
	ntCast_Type(89),
	ntConcat(90),
	ntConcat2(91),
	ntOutput(92),
	ntOP(93),
	ntIF_THEN(94),
	ntELSE(95),
	ntWHILE(96),
	ntFOR(97);
	
	private int value;
	
	private ntCateg(Integer value) {
		this.value = value;
	}
	
	public int getCategValue() {
		return value;
	}
}
