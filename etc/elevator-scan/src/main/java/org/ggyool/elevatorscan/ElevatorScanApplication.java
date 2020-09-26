package org.ggyool.elevatorscan;

import org.ggyool.elevatorscan.domain.*;
import org.ggyool.elevatorscan.dto.ActionRequestDto;
import org.ggyool.elevatorscan.dto.ActionResponseDto;
import org.ggyool.elevatorscan.dto.OnCallResponseDto;
import org.ggyool.elevatorscan.dto.StartApiResponseDto;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class ElevatorScanApplication {

	RestTemplate restTemplate;

	public ElevatorScanApplication() {
		restTemplate = new RestTemplate();
	}

	public static void main(String[] args) throws InterruptedException {
		ElevatorScanApplication sol = new ElevatorScanApplication();
//		sol.problemZero(); // 23
//		sol.problemOne(); // 610
		sol.problemTwo();
		/*
		0번 23
		1번 610
		2번 4대 1-25  1908
		   2대 2대 1861
		 */
	}
	public void problemZero() throws InterruptedException {
		int numberOfElevators = 4;
		StartApiResponseDto startApiResponseDto = startAPI(0, numberOfElevators);
		System.out.println(startApiResponseDto);
		String token = startApiResponseDto.getToken();


		Direction[] directions = new Direction[numberOfElevators];
		for(int i=0; i<numberOfElevators; ++i){
			directions[i] = Direction.UP;
		}
		while(true){
			OnCallResponseDto onCallResponseDto = onCallAPI(token);
			System.out.println(onCallResponseDto);
			if(onCallResponseDto.getIs_end()) break;
			List<Elevator> elevators = onCallResponseDto.getElevators();
			List<Call> calls = onCallResponseDto.getCalls();
			FloorInformation floorInfo = FloorInformation.builder().maxFloor(5).calls(calls).build();
			System.out.println(floorInfo);

			List<Command> commands = new ArrayList<>();
			for(Elevator elevator : elevators){
				elevator.additionalInit(1L, 5L, floorInfo, directions);
				commands.add(elevator.decideCommand());
			}
			ActionRequestDto actionRequestDto = ActionRequestDto.builder().commands(commands).build();
			ActionResponseDto actionResponseDto = actionAPI(token, actionRequestDto);
			System.out.println(actionResponseDto);
			Thread.sleep(50);
		}
	}

	public void problemOne() throws InterruptedException {
		int numberOfElevators = 4;
		StartApiResponseDto startApiResponseDto = startAPI(1, numberOfElevators);
		System.out.println(startApiResponseDto);
		String token = startApiResponseDto.getToken();


		Direction[] directions = new Direction[numberOfElevators];
		for(int i=0; i<numberOfElevators; ++i){
			directions[i] = Direction.UP;
		}
		while(true){
			OnCallResponseDto onCallResponseDto = onCallAPI(token);
			System.out.println(onCallResponseDto);
			if(onCallResponseDto.getIs_end()) break;
			List<Elevator> elevators = onCallResponseDto.getElevators();
			List<Call> calls = onCallResponseDto.getCalls();
			FloorInformation floorInfo = FloorInformation.builder().maxFloor(25).calls(calls).build();
			System.out.println(floorInfo);

			List<Command> commands = new ArrayList<>();
			for(Elevator elevator : elevators){
				elevator.additionalInit(1L, 25L, floorInfo, directions);
				commands.add(elevator.decideCommand());
			}
			ActionRequestDto actionRequestDto = ActionRequestDto.builder().commands(commands).build();
			ActionResponseDto actionResponseDto = actionAPI(token, actionRequestDto);
			System.out.println(actionResponseDto);
			Thread.sleep(50);
		}
	}

	public void problemTwo() throws InterruptedException {
		int numberOfElevators = 4;
		StartApiResponseDto startApiResponseDto = startAPI(2, numberOfElevators);
		System.out.println(startApiResponseDto);
		String token = startApiResponseDto.getToken();


		Direction[] directions = new Direction[numberOfElevators];
		for(int i=0; i<numberOfElevators; ++i){
			directions[i] = Direction.UP;
		}
		while(true){
			OnCallResponseDto onCallResponseDto = onCallAPI(token);
			System.out.println(onCallResponseDto);
			if(onCallResponseDto.getIs_end()) break;
			List<Elevator> elevators = onCallResponseDto.getElevators();
			List<Call> calls = onCallResponseDto.getCalls();
			FloorInformation floorInfo = FloorInformation.builder().maxFloor(25).calls(calls).build();
			System.out.println(floorInfo);

			List<Command> commands = new ArrayList<>();
			for(Elevator elevator : elevators){
//				elevator.additionalInit(1L, 25L, floorInfo, directions);
				if(elevator.getId()%2==1) elevator.additionalInit(1L, 13L, floorInfo, directions);
				else elevator.additionalInit(13L, 25L, floorInfo, directions);
				commands.add(elevator.decideCommand());
			}
			ActionRequestDto actionRequestDto = ActionRequestDto.builder().commands(commands).build();
			ActionResponseDto actionResponseDto = actionAPI(token, actionRequestDto);
			System.out.println(actionResponseDto);
			Thread.sleep(25);
		}
	}


	public StartApiResponseDto startAPI(int problemId, int numberOfElevators){
		String url = "http://localhost:8000/start/";
		String userKey = "tester";
		String uri = url + userKey + '/' + problemId + '/' + numberOfElevators;
		ResponseEntity<StartApiResponseDto> exchange = restTemplate.exchange(uri, HttpMethod.POST, null, StartApiResponseDto.class);
		return exchange.getBody();
	}

	public OnCallResponseDto onCallAPI(String token){
		String url = "http://localhost:8000/oncalls";
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Auth-Token", token);
		HttpEntity httpEntity = new HttpEntity(headers);
		ResponseEntity<OnCallResponseDto> exchange = restTemplate.exchange(url, HttpMethod.GET, httpEntity, OnCallResponseDto.class);
		return exchange.getBody();
	}

	public ActionResponseDto actionAPI(String token, ActionRequestDto actionRequestDto){
		String url = "http://localhost:8000/action";
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Auth-Token", token);
		HttpEntity<ActionRequestDto> httpEntity = new HttpEntity(actionRequestDto, headers);
		ResponseEntity<ActionResponseDto> exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, ActionResponseDto.class);
		return exchange.getBody();
	}

}
