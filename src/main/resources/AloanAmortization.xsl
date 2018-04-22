<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xml:lang="afb"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xml:space="default"
	xmlns:svg="http://www.w3.org/2000/svg" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	version="1.0" xmlns:java="http://xml.apache.org/xslt/java"
	exclude-result-prefixes="java">
	<xsl:output doctype-public="-//W3C//DTD HTML 4.01 Transitional//EN"
		method="pdf" indent="yes" encoding="utf-8" />

	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format"
			xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xs="http://www.w3.org/2001/XMLSchema">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="page"
					reference-orientation="0" page-height="29.7cm" page-width="21cm">
					<fo:region-body font-size="8pt" font-family="sans-serif"
						margin-top="2.5cm" margin-bottom="2cm" margin-left="0.5cm"
						margin-right="0.5cm" />
					<fo:region-before extent="3cm" />
					<fo:region-after extent="1cm" />
				</fo:simple-page-master>


				<fo:simple-page-master master-name="lastPage"
					page-height="30cm" page-width="21cm">
					<fo:region-body font-size="8pt" margin-top="3cm"
						margin-bottom="2cm" margin-left="0.25cm" margin-right="0.25cm" />
					<fo:region-before extent="3cm" />
					<fo:region-after extent="3cm" />
				</fo:simple-page-master>
				<fo:page-sequence-master master-name="all">
					<fo:repeatable-page-master-alternatives>
						<fo:conditional-page-master-reference
							master-reference="page" page-position="first" />
						<fo:conditional-page-master-reference
							master-reference="lastPage" page-position="last" />
					</fo:repeatable-page-master-alternatives>
				</fo:page-sequence-master>
			</fo:layout-master-set>

			<fo:page-sequence master-reference="page"
				initial-page-number="1">
				<fo:static-content flow-name="xsl-region-before">
					<fo:block-container margin-top="3cm" height="0.5cm"
						width="19cm" top="0.01mm" position="absolute">
						<fo:block margin-top="0.75cm">
							<fo:external-graphic content-width="21cm"
								scaling="uniform"
								src="url('data:image/png;base64,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RETEiR16l1mJoe1pEREREdcgW9LC2jjXSsEtqFWpa0DhyFJ9VIvGzdzhq0KdmnBTeN+fSwLOZSyF29EW25Eaq630hIrR+Y4NOKfcpnbOgFP0hMPmWp65lwABJyIiIuLEatVmD1++/75bHyIiIuJaZEtaWDOt77K7BKPJ+3OhlVEKSaZcyeXZyhznpGBL9Xor9yK8euaSgHN+FWBG/a+VmN53SvasxO4JFaNViGMDTgWnXtke5w44xZhA9pyr5i8JAk5ERETEie2BlZuIiIi4dv/x81+wJS2sntYVUXtWgV1LuLY0CkAUIEyxglJ16H2DCmDGhG1ataUx1Bt26nv6vsKNnrb36pxLAs5pVaCtNtWYrun/nnbuGVM9Qar0tsIdG3CKqX5IsETAKcY8n7ZwX2wdAk5ERETEif303/79cPfGfx7fvantavN3buo9m/q73sepcirv1YOIiIi4Fu88/wJb0sImUADQM4Fu4YRpYVmuJqzn9K13bj1yTAUm6bnVbvNauy3qWtD5qg3y6/e09mp5H2ErGks6hkJP7xxMfa5yPeETAAD0Q8CJiIiIiIiIiIih2mkCYEsoKEsDwTSstDBqL4GUXYuuLQ1CdZ0AAAB7hoATEREREREREREfUe/bvP74k9MUEgAAAADAeiDgRERERERERETEh/zsyacO/7p//zR9BAAAAACwLgg4ERERERERERHxe+++dOM0bQQAAAAAsE4IOBERERERERER8eiDmzdPU0YAAAAAAOuFgBMRERERERER8cLV+za/vro6TRcBAAAAAKwbAk5ERERERERExAtW79v89vr6NFUEAAAAALB+CDgRERERERERES9U3rcJAAAAAFuEgBMRERERERER8QLlfZsAAAAAsFUIOBERERERERERL0i9b/P6409OU0MAAAAAANuDgBMRERERERER8ULU+zb/df/+aVoIAAAAAGCbEHAiIiIiIiIiIl6Ad55/4fDt9fVpSggAAAAAYLsQcCIiIiIiIiIi7tz7f3zzNBUEAAAAALB9CDgREREREREREXeq3rf54ObN0zQQAAAALMnnd+6d/gkApoaAExERERERERFxhyrc/Prq6jQFBADwA17ocv3VN4f7Xzw4/RtsFfXjR7d59p8D3T+3Prh9eOX1tw9PPPPy4Uc/+fXhxd//+fQpAEwNASciIiIiIiIi4s787MmneN8mADyCwq/nXnzjGLw8/ZvXvg80FXj++PHffh/IEHRuE/WvBWtp/8I8qL3ffe/D4z3zs1/+7tjuufocAOaBgBMRERERERERcUfefenGadoHAOBhFMTkAYwFnrmsPNsWabiZ96M+g2mwUNNra0+2qAWYDwJORERERERERMSd+M+//PU05QMA8DBvvXPLDWAiCTi3QxRuSq0sJOCchj/86W/fr3SuFQDmg4ATEREREREREXHj6n2bX/79/dN0DwDAoyjkyldwKhTTajRtZ5r/HbaD17dSYRwrCKdB79XM27ek7iH9qAAA5oOAExERERERERFxw/7j5784fH11dZrqAQAo89Htq+O2tApg0pV9tz64ffybwk5W/G0T9ZutMiTcnA61qxdipqq9FTLrBwO8+xRgGQg4ERERERERERE36mdPPnX49vr6NM0DAADwXSBHyDYd+lGAF2rqxwBapUmQDHAeCDgRERERERERETfo3ZduEG4CAMAgWp0L/eTvr9UqWVY5g6GAm/FwHgg4ERERERERERE35v0/vnma2gEAAIjRlqkK5bQKEfrI32/K9r+g/te40FjQmNC237A8BJyIiIiIiIiIiBvx08d+enhw8+ZpWgcAACBGq8osgPnZL3/HKrNO9G7aNOCUlxxyKixXcK6VwZfWBrp2bU2cjwfJ/bU8BJyIiIiIiIiIiBtQ4ebXV6zAAdgamhDXSh8FTK+8/vYmJsEVXlzKij/1x16DCW2lmgYw+ve5UeClLV015hUELXHMudF9m7ajeUkhp54JWqXotYP6ee/toGdEdP2m2giWhYATEREREREREXHlfvbkU7xvE2BjaMLfW+mz9uDwkrY0VWih1Xm91+qFo/e/eHAMxM6NziMfewrkpg5zVZ+FX7ZaNHUvW3fafZF7CSFn/g7SyL0GfPac8K45lW1ql4eAExERERERERFxxd596QbhJlw8Coy2NHmer5xLVViwVhTUWEh1CSuyLLRQGNiKfT//rv6mYPvcaPvQdNyZU40/hcJDK9qkVi7vhUsMOTXOveA6co8/jMjfwVoSloWAExERERERERFxpd579fyT5ADnRsGBTR5vYfJ8aDJ8DeFXRLpKae9YP/UEcBqT+l7+XdvKdC197K28G3tuunZvZXJJhWR74dJCztKPNTz3toox/aGA+ljtofGsHzZ4qzpVHpaDgBMRERERERERcYU+uHnzNH0DcNmkYcraQwQvDPBWP/WsGJybfEvTPZO+U7F1O9l05adCUiMN4tcUYudhpMZjL7p2hbppfTXuLfTR9Xj39dqfT620rt6Uaxr7U5COd/2znvH2/Fb7pNcu02cCzA8BJyIiIiIiIiLiivz0sZ8evr7a/7vvAGrwVkutNURIA0KdY7qlbr6Sbo2T4Fodm57/nklXXrWOpXSFbtTHawp50n41e8nDUk+t4FMAmIb9ewx9NG688G+tz6ce1I/qT/VfbbC95i24W4lW60ob5/kqznxVN8wLASciIiIiIiIi4kr87MmnDv+6f/80bQMApXf8rW0iPT1XhRz5+eVB09pCkPz81rjKdCrsGnuC3DTk0wouQ/1pf29dFTo3eTjVgxeUqt607jTwVfiTltX390Yp5NT17438hxq5uu49PTdK//0pCctBwImIiIiIiIiIuAKvfvXs4dvr69OUDQCIdDtQT4VNawgK8zAnOr80DNF1pQHZucmvQee+pvObijSoU3/YO/VqSQPOHPu76lwT6Za8Ov8e0uvWij6Na7VbOqb1z9aWaeBrn11SyCnTwHcveNtwm2sb92PIt+yuVWMBloOAExERERERERHxzN596cZpqgYAckoBQq9adabAZiqHzk+BULSdoVffOcxX+Zle2S1ZCsg9vTpS077OP0vrWWvf9mwXm4bCaWDvrehT+yjYU9DpjSnv/LZu6f73ym9d7zql7jWv/BZtfW6Ye9yOec0QcCIiIiIiIiIintEHN2+epmkAIGJoa0RErLNna2eFNvb9dLVrbwi0V6f+IQaeX41xjf+avlWZltXgMB4CTkRERERERETEM/jpYz89XH/8yWmKBgCGWHN4oHPTqh/vsy0ZreLE/ZiuwKwlHRfpNrPpys5LV0GYwq1LCX0vIczNA0utwt/Se6EvAQJORERERERERMSF/ezJpw5fX+3vXWQAc7LmCXVNfAsFPlsNOvWexksIrC45xNU91ENaR/6eRY39Swi7Sur69c5GcSkhp7YhLr2Pcw9G71BVH+uztJ/13IflIeBERERERERERFzQq189e/j2+vo0NQMANeQT6aVVNEubBz5ia0FnulJJ577XgMZW2Y0JZhQEe383Ffh5f1+Dum96SMeD945BtWm6je2laT9wMBR27jn01XgQ6ve9XmdtYKm+1spNC7hhWY4Bp/6PNSIiIiIiIiIizuu9V/mFP0AreWBkk+sK4s7t0HafWuXjrRhUwObVdy696/DKbdn8GhVIeOVKWh36357Pz21vCJP+oMDuPw8doxTsq578nPagR8/42orpOFrrWB+r/eAD1s3jjz9++H+Ob72K5hFJ9AAAAABJRU5ErkJggg==')" />
						</fo:block>
					</fo:block-container>
				</fo:static-content>
				<fo:static-content flow-name="xsl-region-after">
					<fo:block-container margin-top="0.5cm"
						margin-left="0.45cm" margin-right="0.45cm" height="0.5cm" width="21cm"
						top="0.01mm" position="absolute">
						<fo:block>
							<fo:table border="0.6pt solid black">
								<fo:table-body>
									<fo:table-row>
										<fo:table-cell>
											<fo:block></fo:block>
										</fo:table-cell>
									</fo:table-row>
								</fo:table-body>
							</fo:table>
						</fo:block>
						<fo:block margin-top="2px">
							<fo:block text-align="center" font-size="7px">
								Page
								<fo:page-number />
								of
								<fo:page-number-citation ref-id="TheVeryLastPage" />
							</fo:block>
						</fo:block>
					</fo:block-container>
				</fo:static-content>
				<fo:flow flow-name="xsl-region-body">



					<fo:block-container>
						<fo:block>
							graph


							
						</fo:block>

						<!-- <fo:block>
							<fo:instream-foreign-object>
								<svg:svg>
									<svg:g>
										<svg:l x1="10" y1="10" x2="85" y2="10" style="stroke: #006600;"></svg:l>
									</svg:g>
								</svg:svg>
							</fo:instream-foreign-object>
						</fo:block>
 -->
						<!-- <fo:block text-align="center"> <fo:external-graphic src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/PieChartFraction_OneFourth.svg/2000px-PieChartFraction_OneFourth.svg.png" 
							content-width="5cm"></fo:external-graphic> </fo:block> -->
						<fo:block text-align="center">
							<fo:external-graphic
								src="C://Users//online09//Documents//workspace-sts-3.7.1.RELEASE//ApacheFopTrial//Resources//cc//cctemp3.PNG"
								content-width="5cm"></fo:external-graphic>
						</fo:block>

						<fo:block>
							<fo:table font-family="Arial" font-size="14pt"
								font-weight="normal" text-align="center" width="100%"
								keep-with-next="always" table-layout="fixed">
								<fo:table-column column-width="proportional-column-width(1)" />
								<fo:table-body>
									<fo:table-row>

										<fo:table-cell>
											<fo:block>
												<fo:inline>
													<fo:inline>الحساب</fo:inline>
												</fo:inline>
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
								</fo:table-body>
							</fo:table>
						</fo:block>


						<fo:block>
							<fo:bidi-override unicode-bidi="embed"
								direction="ltr" font-family="Arial">
								<fo:inline>الحساب</fo:inline>
							</fo:bidi-override>
						</fo:block>

						<fo:block xml:lang="ar">
							sca
							<fo:bidi-override direction="ltr" font-family="Courier">
								<xsl:value-of select="employees/employee/designation" />
							</fo:bidi-override>
						</fo:block>

						<fo:block>
							<fo:external-graphic content-width="3cm"
								content-height="0.5cm" scaling="uniform"
								src="url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAALoAAABJCAYAAACKCDxGAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAEnQAABJ0Ad5mH3gAAAOnSURBVHhe7ZkLkm0wEEDvtmzIduzGZizGE+SDhDB4On1OVVdNzbjDTU66k/brARSA6KACRAcVIDqoANFBBYgOKkB0UAGigwoQHVSA6KACRAcVIDqoANFBBYgOKkB0UAGigwoQHVSA6KACRAcVIDqoANFBBYgOM13fNO38c3kgOkx0TV/96r5U1REdRrqm6n+/3xRVM+T3skD0HNqmb0qb+RVtPUvuIpHdu7ZvBY4Foh/S9vUw8VXhpueKbq6rBe5vEP0AJ4DE2T3BRvTY9mXcx8tc9Ii+R1vvT3xhLGTfLOyub6rU374Pou8xZ7Bp8svtSFjsgTSesactHKIXiu9GVMUfSF0Fi4ocZHSB1Q3RD7GZTIHotoIlRPZbG3nVDdEP8Zms8POoFz0hsuTqhugZ2ExWvOhH1csdzhG9SGwmK1/0g+oVdKGkjQWiZ7DfjSgLW72i3zXoQkkbC0TPYc5kGkTPbTEi+oOYbPN0yeyaZnsQUyj6YYtR2N5FjuimbD7ev50z1noSPyd68PLGxl3i2X14dKzl9tLFiP5GNneTvO4qzHvT90QfRE59WfeM8fjzMx60GF0vHdEfYBz8p19SBNlqLYyd/LMrrW3znnl13SRTpIXnJDyIP0m432L0vXRZL41kiG6y2BsZJMyWodSXRJ+EOf6IWWChVH7BrbOzy6ZZcVVEf//YsyP6g4wT/FKpdBO5uF9i777LLMzhZ6brlpfN98v4zl68WFx5sZNeaCOp7d3HkSP6axnElu7wfvniheQ+93jdakGMAp+538625tT6HLCVA9Ffxg78uYx6na2gNsudm9xdYQK29xu4eC5xY7WKM0PnqkTsQ25BIfrtLCbvhS3MNNFLyewz5AvjtwD7Wd1ft/zfpoqcF30kkd2PFpzDZu3YWCP6g4SHxCCeSvAx0f1eOE++bWaNf87/XxOBPON3vij6SLjQgshJFE7m2P1jW7vvI0P01KQ9GquJTCy2smNH9Bcq650IEd1gM8lbsZ7kt+//hUiLnr0N+giCRDe8mdm3k7zcZmiIlOix338bYaJ7npcuPpmprsYmFqV9pxqE1yUOkf8vImMwPGMtLJsbxIoOcAZEBxUgOqigYNGng+tTvXaQRbmiL/rest7iwf0UKvq2DSmt7wv3UmxGX7Yf5fV94V6KP4yavjfZHIoXHcCA6KACRAcVIDqoANFBBYgOKkB0UAGigwoQHVSA6KACRAcVIDqoANFBBYgOKkB0UEDf/wPXYshB6aqliwAAAABJRU5ErkJggg==')" />
						</fo:block>



						<fo:block>
							Loan Amortization Header
							<fo:table border="0.8pt solid black">
								<fo:table-column border="0.8pt solid black"
									column-width="50mm" />
								<fo:table-column border="0.8pt solid black"
									column-width="50mm" />
								<fo:table-column border="0.8pt solid black"
									column-width="50mm" />
								<fo:table-column border="0.8pt solid black"
									column-width="50mm" />

								<fo:table-body>

									1st Row
									<fo:table-row border="0.8pt solid black">
										<fo:table-cell padding="2px">
											<fo:block font-weight="bold" font-size="9px">
												Loan Account
												No
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="2px" text-align="center">
											<fo:block font-weight="bold" font-size="9px">
												989854654
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="2px">
											<fo:block font-weight="bold" font-size="9px">
												Customer No
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="2px" text-align="center">
											<fo:block font-weight="bold" font-size="9px">
												81298995
											</fo:block>
										</fo:table-cell>
									</fo:table-row>

									2nd Row
									<fo:table-row border="0.8pt solid black">
										<fo:table-cell padding="2px">
											<fo:block font-weight="bold" font-size="9px">
												Customer Name
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="2px 0px 2px 20px"
											number-columns-spanned="3">
											<fo:block font-size="9px">
												Rahul Johny
											</fo:block>
										</fo:table-cell>

									</fo:table-row>


									3rd Row
									<fo:table-row border="0.8pt solid black">
										<fo:table-cell padding="2px">
											<fo:block font-weight="bold" font-size="9px">
												Disburse Date
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="2px" text-align="center">
											<fo:block font-size="9px">
												15/12/2017
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="2px">
											<fo:block font-weight="bold" font-size="9px">
												Loan Amount
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="2px" text-align="center">
											<fo:block font-weight="bold" font-size="9px">
												KWD 454
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
									4th Row
									<fo:table-row border="0.8pt solid black">
										<fo:table-cell padding="2px">
											<fo:block font-weight="bold" font-size="9px">
												No of
												Repayments(Months)
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="2px" text-align="center">
											<fo:block font-size="9px">
												180
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="2px">
											<fo:block font-weight="bold" font-size="9px">
												Monthly
												Installment
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="2px" text-align="center">
											<fo:block font-size="9px">
												KWD 12
											</fo:block>
										</fo:table-cell>
									</fo:table-row>

									5th Row
									<fo:table-row border="0.8pt solid black">
										<fo:table-cell padding="2px">
											<fo:block font-weight="bold" font-size="9px">
												Total
												Repayment
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="2px" text-align="center">
											<fo:block font-size="9px">
												KWD 10256565
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="2px">
											<fo:block font-weight="bold" font-size="9px">
												Total
												Interest
												<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'idCustomer']/udfvalue"/>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="2px" text-align="center">
											<fo:block font-size="9px">
												KWD
												<xsl:value-of
													select="format-number(sum(employees/employee/intpercent),'0.000' ) " />
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
								</fo:table-body>
							</fo:table>
						</fo:block>


						Loan Repayment Schedule
						<fo:block margin-top="5px">
							<fo:table text-align="center" border="0.8pt solid black">
								<fo:table-column border="0.8pt solid black"
									column-width="7.5mm" />
								<fo:table-column border="0.8pt solid black"
									column-width="32.5mm" />
								<fo:table-column border="0.8pt solid black"
									column-width="32.5mm" />
								<fo:table-column border="0.8pt solid black"
									column-width="30mm" />
								<fo:table-column border="0.8pt solid black"
									column-width="32.5mm" />
								<fo:table-column border="0.8pt solid black"
									column-width="32.5mm" />
								<fo:table-column border="0.8pt solid black"
									column-width="32.5mm" />
								<fo:table-body>

									<fo:table-row border="0.8pt solid black">

										<fo:table-cell padding="2px"
											number-columns-spanned="7">

											<fo:block xml:lang="ar">
												<fo:bidi-override unicode-bidi="embed"
													direction="ltr" font-family="Tradi">
													الحساب
												</fo:bidi-override>
											</fo:block>
										</fo:table-cell>

									</fo:table-row>
									<fo:table-row font-size="9px">
										<fo:table-cell padding="1px">
											<fo:block>No.</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="1px">
											<fo:block>Payment Date</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="1px">
											<fo:block>Payment</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="1px">
											<fo:block>Interest %</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="1px">
											<fo:block>Principal</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="1px">
											<fo:block>Interest</fo:block>
										</fo:table-cell>
										<fo:table-cell padding="1px">
											<fo:block>Balance</fo:block>
										</fo:table-cell>
									</fo:table-row>
								</fo:table-body>

							</fo:table>

						</fo:block>

						Transactions
						<fo:block margin-top="5px">
							<!-- <fo:table text-align="center" border="0.8pt solid black"
								border-before-width.length="1pt"
								border-before-width.conditionality="retain"
								border-after-width.length="1pt"
								border-after-width.conditionality="retain">
								<fo:table-column border="0.8pt solid black"
									column-width="7.5mm" />
								<fo:table-column border="0.8pt solid black"
									column-width="32.5mm" />
								<fo:table-column border="0.8pt solid black"
									column-width="32.5mm" />
								<fo:table-column border="0.8pt solid black"
									column-width="30mm" />
								<fo:table-column border="0.8pt solid black"
									column-width="32.5mm" />
								<fo:table-column border="0.8pt solid black"
									column-width="32.5mm" />
								<fo:table-column border="0.8pt solid black"
									column-width="32.5mm" />
								<fo:table-body>
									<xsl:for-each select="employees/employee">
										<fo:table-row font-size="7px">
											<fo:table-cell padding-top="2px">
												<fo:block>
													<xsl:value-of select="position()" />
												</fo:block>
											</fo:table-cell>
											<fo:table-cell text-align="left" padding-top="2px"
												padding-left="3px">
												<fo:block>
													<xsl:value-of select="paymentDate" />
												</fo:block>
											</fo:table-cell>
											<fo:table-cell text-align="left" padding-top="2px"
												padding-left="3px">
												<fo:block>
													KWD
													<xsl:value-of select="payment" />
												</fo:block>
											</fo:table-cell>
											<fo:table-cell padding-top="2px">
												<fo:block>
													<xsl:value-of select="intpercent" />
												</fo:block>
											</fo:table-cell>
											<fo:table-cell text-align="left" padding-top="2px"
												padding-left="3px">
												<fo:block>
													KWD
													<xsl:value-of select="principal" />
												</fo:block>
											</fo:table-cell>
											<fo:table-cell text-align="left" padding-top="2px"
												padding-left="3px">
												<fo:block>
													KWD
													<xsl:value-of select="interest" />
												</fo:block>
											</fo:table-cell>
											<fo:table-cell text-align="left" padding-top="2px"
												padding-left="3px">
												<fo:block>
													KWD
													<xsl:value-of select="balance" />
												</fo:block>
											</fo:table-cell>
										</fo:table-row>
									</xsl:for-each>
								</fo:table-body>

							</fo:table> -->

						</fo:block>




						<fo:block id="TheVeryLastPage">
						</fo:block>
					</fo:block-container>
				</fo:flow>
			</fo:page-sequence>



		</fo:root>
	</xsl:template>
</xsl:stylesheet>


