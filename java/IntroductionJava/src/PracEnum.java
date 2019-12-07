enum Race {
     TERRAN("테란"), ZERG("저그"), PROTOSS("프로토스");
     final private String HanRace;
     Race(String Han) {
          HanRace = Han;
     }
     String getHanName() {
          return HanRace;
     }
}

class PracEnum {
     public static void main(String args[]) {
          Race MyTeam;
          MyTeam = Race.ZERG;
          System.out.println(MyTeam.getHanName());
     }
}