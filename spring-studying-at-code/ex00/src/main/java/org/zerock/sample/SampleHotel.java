package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;
//import lombok.AllArgsConstructor;
@Component
@ToString
@Getter
//@AllArgsConstructor
@RequiredArgsConstructor
public class SampleHotel {
	@NonNull
	private Chef chef;
	/*
	public SampleHotel(Chef chef)
	{
		this.chef = chef;
	}*/
}
	