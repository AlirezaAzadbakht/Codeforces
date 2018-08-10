#include <iostream>
#include<cstdio>
#include<string>
#include<cstring>
using namespace std;

int main() {
	int n;
	scanf("%d", &n);
	int addLater = 0;
	bool data[1000001];
	for (int i = 0; i < 1000001; i++)
		data[i] = false;
	for (int k = 0; k < n; k++) {
		int a;
		scanf("%d", &a);
		data[a] = true;
		if (data[1000000 + 1 - a])
			addLater++;
	}

	int i = 1;
	int j = 1000000;
	int result[n];
	int tempn = n;
	int k = 0;
	printf("%d\n", n);

	while (i < 500000 + 1) {
		if (n == 0)
			break;
		if ((data[i] == 1) && (data[j] == 0)) {
			result[k] = j;
			k++;
			n--;
			//cout<<"1*"<< j <<endl;
		} else if ((data[i] == 0) && (data[j] == 1)) {
			result[k] = i;
			k++;
			n--;
			//cout<<"2*"<< i <<endl;
		} else if ((addLater > 0) && (data[i] == 0) && (data[j] == 0)) {
			result[k] = j;
			result[k + 1] = i;
			addLater--;
			k += 2;
			n -= 2;
		}
		i = i + 1;
		j = j - 1;
	}

	for (int ii = 0; ii < tempn; ii++) {
		if (ii != 0)
			printf(" ");
		printf("%d", result[ii]);
	}
	printf("\n");
	return 0;
}
