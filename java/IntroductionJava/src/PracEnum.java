enum Race {
     TERRAN("�׶�"), ZERG("����"), PROTOSS("�����佺");
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