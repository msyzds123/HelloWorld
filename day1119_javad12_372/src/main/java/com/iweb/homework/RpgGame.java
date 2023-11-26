package com.iweb.homework;

/**
 * @author Min
 * @date 2023/11/21 21:41
 */
public class RpgGame {
    int missionNum = 0;
    int missionCapacity = 20;
    public synchronized void publishTask(){
        while (true){
            if(missionNum<missionCapacity){
                missionNum++;
                System.out.printf("npc发布任务，大厅剩余%d个任务\n",missionNum);
                notifyAll();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public synchronized void getTask(){
        while (true){
            if(missionNum>0){
                missionNum--;
                System.out.printf("玩家接取到一个任务,大厅剩余%d个任务\n",missionNum);
                notifyAll();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final RpgGame game = new RpgGame();
        for (int i = 0; i < 3; i++) {
            Thread npc = new Thread(){
                public void run(){
                    game.publishTask();
                }
            };
            Thread player = new Thread(){
                public void run(){
                    game.getTask();
                }
            };
            npc.start();
            player.start();
        }
    }
}
