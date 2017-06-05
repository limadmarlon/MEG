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
	ntStatement(66),
	ntExp_Start(66),
	ntId_asfirst(68),
	ntNotId_asfirst(69),
	ntExp_rel_aritm(70),
	ntNot_log_value(71),
	ntLog_noId(72),
	ntUna_aritm_value(73),
	ntPar_aritm_value(74),
	ntAritm_no_id(75),
	ntExp_log(76),
	ntExp_logr(77),
	ntExp_log2(78),
	ntvalue_log(79),
	ntExp_rel(80),
	ntExp_relr(81),
	ntExp_aritm(82),
	ntExp_aritmr(83),
	ntExp_aritm2(84),
	ntExp_aritm2r(85),
	ntExp_aritm3(86),
	ntExp_aritm4(87),
	ntExp_Paren_Cast(88),
	ntvalue_aritm(89),
	ntDiffer2(90),
	ntCC(91),
	ntIndex(92),
	ntATT(93),
	ntATTr(94),
	ntCast(95),
	ntCastParam(96),
	ntCast_Type(97),
	ntConcat(98),
	ntConcat2(99),
	ntOutput(100),
	ntOP(101),
	ntIF_THEN(102),
	ntELSE(103),
	ntWHILE(104),
	ntFOR(105);

	
	private int value;
	
	private ntCateg(Integer value) {
		this.value = value;
	}
	
	public int getCategValue() {
		return value;
	}
}
