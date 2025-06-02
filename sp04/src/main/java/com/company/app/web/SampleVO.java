package com.company.app.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"lastName"})
public class SampleVO {

	private int mno;
//	@JsonProperty("name")
	private String firstName;
//	@JsonIgnore
	private String lastName;
}
