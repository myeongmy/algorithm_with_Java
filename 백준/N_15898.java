//백준 15898번 피아의 아틀리에~ 신비한 대회의 연금술사~
//브루트 포스 + 빡구현

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_15898 {
	static class Point {
		int num;
		char color;

		Point(int num, char color) {
			this.num = num;
			this.color = color;
		}
	}

	static Point[][] gama = new Point[5][5];
	static Point[][][] zaeryo;
	static Point [][][][] zaeryo2;
	static int[] c = new int[11];
	static int[] result = new int[3];
	static int max = Integer.MIN_VALUE;

	static Point[][] clockwise(int num, int cnt) {
		Point[][] temp = new Point[4][4]; // 저장할 배열
		Point[][] temp2 = new Point[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				temp2[i][j] = new Point(zaeryo[num][i][j].num, zaeryo[num][i][j].color);
			}
		}

		for (int k = 0; k < cnt; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					temp[i][j] = new Point(temp2[3 - j][i].num, temp2[3 - j][i].color);
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					temp2[i][j] = new Point(temp[i][j].num, temp[i][j].color);
				}
			}
		}

		return temp;
	}

	static void go(int index, int n) {
		if (index == 3) {
			for (int zeroLo = 1; zeroLo <= 4; zeroLo++) {
				for (int zeroDir = 1; zeroDir <= 4; zeroDir++) {
					for (int oneLo = 1; oneLo <= 4; oneLo++) {
						for (int oneDir = 1; oneDir <= 4; oneDir++) {
							for (int twoLo = 1; twoLo <= 4; twoLo++) {
								for (int twoDir = 1; twoDir <= 4; twoDir++) {
									// 시물레이션
									Point[][] gama2 = new Point[5][5];
									for (int i = 0; i < 5; i++) {
										for (int j = 0; j < 5; j++) {
											gama2[i][j] = new Point(gama[i][j].num, gama[i][j].color);
										}
									}
									// 첫번째 재료
									Point[][] temp = new Point[4][4];
									for(int i=0;i<4;i++) {
										for(int j=0;j<4;j++) {
											temp[i][j] = new Point(zaeryo2[result[0]][zeroDir-1][i][j].num, zaeryo2[result[0]][zeroDir-1][i][j].color);
										}
									}
									if (zeroLo == 1) {
										for (int i = 0; i < 4; i++) {
											for (int j = 0; j < 4; j++) {
												gama2[i][j].num += temp[i][j].num;
												if (gama2[i][j].num < 0)
													gama2[i][j].num = 0;
												if (gama2[i][j].num > 9)
													gama2[i][j].num = 9;
												if (temp[i][j].color != 'W')
													gama2[i][j].color = temp[i][j].color;
											}
										}
									} else if (zeroLo == 2) {
										for (int i = 0; i < 4; i++) {
											for (int j = 1; j < 5; j++) {
												gama2[i][j].num += temp[i][j - 1].num;
												if (gama2[i][j].num < 0)
													gama2[i][j].num = 0;
												if (gama2[i][j].num > 9)
													gama2[i][j].num = 9;
												if (temp[i][j - 1].color != 'W')
													gama2[i][j].color = temp[i][j - 1].color;
											}
										}
									} else if (zeroLo == 3) {
										for (int i = 1; i < 5; i++) {
											for (int j = 0; j < 4; j++) {
												gama2[i][j].num += temp[i - 1][j].num;
												if (gama2[i][j].num < 0)
													gama2[i][j].num = 0;
												if (gama2[i][j].num > 9)
													gama2[i][j].num = 9;
												if (temp[i - 1][j].color != 'W')
													gama2[i][j].color = temp[i - 1][j].color;
											}
										}
									} else if (zeroLo == 4) {
										for (int i = 1; i < 5; i++) {
											for (int j = 1; j < 5; j++) {
												gama2[i][j].num += temp[i - 1][j - 1].num;
												if (gama2[i][j].num < 0)
													gama2[i][j].num = 0;
												if (gama2[i][j].num > 9)
													gama2[i][j].num = 9;
												if (temp[i - 1][j - 1].color != 'W')
													gama2[i][j].color = temp[i - 1][j - 1].color;
											}
										}
									}

									// 두번째 재료
									temp = new Point[4][4];
									for(int i=0;i<4;i++) {
										for(int j=0;j<4;j++) {
											temp[i][j] = new Point(zaeryo2[result[1]][oneDir-1][i][j].num, zaeryo2[result[1]][oneDir-1][i][j].color);
										}
									}
									if (oneLo == 1) {
										for (int i = 0; i < 4; i++) {
											for (int j = 0; j < 4; j++) {
												gama2[i][j].num += temp[i][j].num;
												if (gama2[i][j].num < 0)
													gama2[i][j].num = 0;
												if (gama2[i][j].num > 9)
													gama2[i][j].num = 9;
												if (temp[i][j].color != 'W')
													gama2[i][j].color = temp[i][j].color;
											}
										}
									} else if (oneLo == 2) {
										for (int i = 0; i < 4; i++) {
											for (int j = 1; j < 5; j++) {
												gama2[i][j].num += temp[i][j - 1].num;
												if (gama2[i][j].num < 0)
													gama2[i][j].num = 0;
												if (gama2[i][j].num > 9)
													gama2[i][j].num = 9;
												if (temp[i][j - 1].color != 'W')
													gama2[i][j].color = temp[i][j - 1].color;
											}
										}
									} else if (oneLo == 3) {
										for (int i = 1; i < 5; i++) {
											for (int j = 0; j < 4; j++) {
												gama2[i][j].num += temp[i - 1][j].num;
												if (gama2[i][j].num < 0)
													gama2[i][j].num = 0;
												if (gama2[i][j].num > 9)
													gama2[i][j].num = 9;
												if (temp[i - 1][j].color != 'W')
													gama2[i][j].color = temp[i - 1][j].color;
											}
										}
									} else if (oneLo == 4) {
										for (int i = 1; i < 5; i++) {
											for (int j = 1; j < 5; j++) {
												gama2[i][j].num += temp[i - 1][j - 1].num;
												if (gama2[i][j].num < 0)
													gama2[i][j].num = 0;
												if (gama2[i][j].num > 9)
													gama2[i][j].num = 9;
												if (temp[i - 1][j - 1].color != 'W')
													gama2[i][j].color = temp[i - 1][j - 1].color;
											}
										}
									}

									// 세번째 재료
									temp = new Point[4][4];
									for(int i=0;i<4;i++) {
										for(int j=0;j<4;j++) {
											temp[i][j] = new Point(zaeryo2[result[2]][twoDir-1][i][j].num, zaeryo2[result[2]][twoDir-1][i][j].color);
										}
									}
									if (twoLo == 1) {
										for (int i = 0; i < 4; i++) {
											for (int j = 0; j < 4; j++) {
												gama2[i][j].num += temp[i][j].num;
												if (gama2[i][j].num < 0)
													gama2[i][j].num = 0;
												if (gama2[i][j].num > 9)
													gama2[i][j].num = 9;
												if (temp[i][j].color != 'W')
													gama2[i][j].color = temp[i][j].color;
											}
										}
									} else if (twoLo == 2) {
										for (int i = 0; i < 4; i++) {
											for (int j = 1; j < 5; j++) {
												gama2[i][j].num += temp[i][j - 1].num;
												if (gama2[i][j].num < 0)
													gama2[i][j].num = 0;
												if (gama2[i][j].num > 9)
													gama2[i][j].num = 9;
												if (temp[i][j - 1].color != 'W')
													gama2[i][j].color = temp[i][j - 1].color;
											}
										}
									} else if (twoLo == 3) {
										for (int i = 1; i < 5; i++) {
											for (int j = 0; j < 4; j++) {
												gama2[i][j].num += temp[i - 1][j].num;
												if (gama2[i][j].num < 0)
													gama2[i][j].num = 0;
												if (gama2[i][j].num > 9)
													gama2[i][j].num = 9;
												if (temp[i - 1][j].color != 'W')
													gama2[i][j].color = temp[i - 1][j].color;
											}
										}
									} else if (twoLo == 4) {
										for (int i = 1; i < 5; i++) {
											for (int j = 1; j < 5; j++) {
												gama2[i][j].num += temp[i - 1][j - 1].num;
												if (gama2[i][j].num < 0)
													gama2[i][j].num = 0;
												if (gama2[i][j].num > 9)
													gama2[i][j].num = 9;
												if (temp[i - 1][j - 1].color != 'W')
													gama2[i][j].color = temp[i - 1][j - 1].color;
											}
										}
									}

									// 품질 계산
									int red = 0;
									int blue = 0;
									int green = 0;
									int yellow = 0;
									for (int i = 0; i < 5; i++) {
										for (int j = 0; j < 5; j++) {
											if (gama2[i][j].color == 'R') {
												red += gama2[i][j].num;
											} else if (gama2[i][j].color == 'B') {
												blue += gama2[i][j].num;
											} else if (gama2[i][j].color == 'G') {
												green += gama2[i][j].num;
											} else if (gama2[i][j].color == 'Y') {
												yellow += gama2[i][j].num;
											}
										}
									}

									int quality = 7 * red + 5 * blue + 3 * green + 2 * yellow;
									if (max < quality)
										max = quality;
								}
							}
						}
					}
				}
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (c[i] == 1)
				continue;
			c[i] = 1;
			result[index] = i;
			go(index + 1, n);
			result[index] = 0;
			c[i] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			zaeryo = new Point[n][4][4];

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					gama[i][j] = new Point(0, 'W');
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 4; j++) {
					String[] arr = br.readLine().split(" ");
					for (int k = 0; k < 4; k++) {
						zaeryo[i][j][k] = new Point(Integer.parseInt(arr[k]), 'W');
					}
				}

				for (int j = 0; j < 4; j++) {
					String[] arr = br.readLine().split(" ");

					for (int k = 0; k < 4; k++) {
						zaeryo[i][j][k].color = arr[k].charAt(0);
					}
				}
			}
			zaeryo2 = new Point[n][4][4][4];
			for(int i=0;i<n;i++) {
				for(int j=0;j<4;j++) {
					Point [][] temp = clockwise(i, j+1);
					for(int m=0;m<4;m++) {
						for(int k=0;k<4;k++) {
							zaeryo2[i][j][m][k] = new Point(temp[m][k].num, temp[m][k].color);
						}
					}
				}
			}
			go(0, n);
			System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
