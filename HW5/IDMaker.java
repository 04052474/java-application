import java.util.Random;
/* ========== �����Ҳ��;� ========== */
	public class IDMaker {
		static String checkHead = "ABCDEFGHJKLMNPQRSTUVWXYZIO";
		public static void main(String[] args) {
			Random r = new Random();
			String s = "";
			int checknum = 0;	// ���ͫe9�X���P�ɭp�ⲣ�����ҽX

			// ���ͲĤ@�ӭ^��r��
			int t=(r.nextInt(26)+65);
			s+=(char)t;
			t=checkHead.indexOf((char)t)+10;
			checknum += t/10;
			checknum += t%10*9;

			// ���Ͳ�2�ӼƦr (1~2)
			s += Integer.toString(t = r.nextInt(2)+1);
			checknum += t*8;

			// ���ͫ�8�X
			for (int i=2; i<9; i++){
				s += Integer.toString(t = r.nextInt(10));
				checknum += t*(9-i);
			}
			// �������ҽX�p��
			checknum = (10-((checknum)%10))%10;
			s+=Integer.toString(checknum);
			System.out.println(s);
		}
	}