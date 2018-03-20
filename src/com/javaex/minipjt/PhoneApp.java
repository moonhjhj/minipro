package com.javaex.minipjt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp extends Phone {

	public static void main(String[] args) throws IOException {
		List<Phone> phone = new ArrayList<Phone>();
		System.out.println("********************************");
		System.out.println("*        전화번호 관리 프로그램                    *");
		System.out.println("********************************");

		Scanner sc = new Scanner(System.in);
		boolean gogo = true;
		while (gogo) {

			System.out.println("\n");
			System.out.println("1.리스트   2.등록   3.삭제   4.검색   5.종료");
			System.out.println("--------------------------------");
			System.out.print(">메뉴번호:");

			int num = sc.nextInt();
			switch (num) {
			case 1:

				Reader fr = new FileReader("phoneDB_.txt");
				BufferedReader br = new BufferedReader(fr);

				while (true) {
				
					String line = br.readLine();

					if (line == null) {

						break;
					}
					String a[] = line.split(",");
					phone.add(new Phone(a[0], a[1], a[2]));
				}
				System.out.println("\n");
				System.out.println("<1.리스트>");
				for (int i = 0; i < phone.size(); i++) {

					System.out.println((i + 1) + ": " + phone.get(i).showInfo());
				}

				br.close();
				break;

			case 2:
				System.out.println("<2.등록>");
				fr = new FileReader("phoneDB_.txt");
				br = new BufferedReader(fr);

				while (true) {
					String line = br.readLine();

					if (line == null) {

						break;
					}
					String a[] = line.split(",");
					phone.add(new Phone(a[0], a[1], a[2]));
				}

				br.close();
				fr.close();
				System.out.print(">이름 :");
				String name = sc.next();
				System.out.print(">휴대전화:");
				String hp = sc.next();
				System.out.print(">회사전화:");
				String company = sc.next();
				// 여긴 새로운 연락처 받는 부분
				phone.add(new Phone(name, hp, company));

				Writer fw = new FileWriter("phoneDB_.txt");
				BufferedWriter bw = new BufferedWriter(fw);

				for (int i = 0; i < phone.size(); i++) {
					bw.write(phone.get(i).getName() + "," + phone.get(i).getHp() + "," + phone.get(i).getCompany());
					bw.newLine();
					bw.flush();
				}

				System.out.println("\n" + "[등록되었습니다.]");
				bw.close();
				break;

			case 3:

				System.out.println("<3.삭제>");
				System.out.println(">번호: ");
				fr = new FileReader("phoneDB_.txt");
				br = new BufferedReader(fr);

				while (true) {
					String line = br.readLine();

					if (line == null) {

						break;
					}
					String a[] = line.split(",");
					phone.add(new Phone(a[0], a[1], a[2]));
				}

				br.close();

				int numremove = sc.nextInt();
				phone.remove(numremove);
				fw = new FileWriter("phoneDB_.txt");
				bw = new BufferedWriter(fw);

				for (int i = 0; i < phone.size(); i++) {
					bw.write(phone.get(i).getName() + "," + phone.get(i).getHp() + "," + phone.get(i).getCompany());
					bw.newLine();
					bw.flush();
				}

				bw.close();
				fw.close();
				break;

			case 4:

				System.out.println("<4.검색>");
				System.out.println(">이름: ");
				fr = new FileReader("phoneDB_.txt");
				br = new BufferedReader(fr);

				while (true) {
					String line = br.readLine();

					if (line == null) {

						break;
					}
					String a[] = line.split(",");
					phone.add(new Phone(a[0], a[1], a[2]));
				}

				br.close();
				sc.nextLine();
				String searchnm = sc.nextLine();

				for (int i = 0; i < phone.size(); i++) {
					if (phone.get(i).getName().contains(searchnm)) {
						System.out.println(phone.get(i).getName());
					}

				}

				break;

			case 5:
				gogo = false;
				System.out.println("프로그램 종료");

				break;

			default:

				System.out.println("다시입력해주세요");

				break;

			}

		}
		sc.close();
	}

}
