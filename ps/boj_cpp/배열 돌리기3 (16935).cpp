#include <algorithm>
#include <iostream>
using namespace std;

int n, m, calcN, arrow;
int arr[100][100];
int brr[100][100];


void reverseTopDown()
{
	int(*farr)[100];
	int(*tarr)[100];
	if (arrow == 0) farr = arr, tarr = brr;
	else farr = brr, tarr = arr;
	for (int i = 0; i<n; ++i)
	{
		for (int j = 0; j<m; ++j)
		{
			tarr[n - 1 - i][j] = farr[i][j];
		}
	}
	arrow = 1 - arrow;
}

void reverseLtRt()
{
	int(*farr)[100];
	int(*tarr)[100];
	if (arrow == 0) farr = arr, tarr = brr;
	else farr = brr, tarr = arr;
	for (int i = 0; i<n; ++i)
	{
		for (int j = 0; j<m; ++j)
		{
			tarr[i][j] = farr[i][m - 1 - j];
		}
	}
	arrow = 1 - arrow;
}

void turnRight()
{
	int(*farr)[100];
	int(*tarr)[100];
	if (arrow == 0) farr = arr, tarr = brr;
	else farr = brr, tarr = arr;
	for (int i = 0; i<n; ++i)
	{
		for (int j = 0; j<m; ++j)
		{
			tarr[j][n-1-i] = farr[i][j];
		}
	}
	swap(n, m);
	arrow = 1 - arrow;
}

void turnLeft()
{
	int(*farr)[100];
	int(*tarr)[100];
	if (arrow == 0) farr = arr, tarr = brr;
	else farr = brr, tarr = arr;
	for (int i = 0; i<n; ++i)
	{
		for (int j = 0; j<m; ++j)
		{
			tarr[m-1-j][i] = farr[i][j];
		}
	}
	swap(n, m);
	arrow = 1 - arrow;
}

void printArr()
{
	int(*parr)[100];
	if (arrow == 0) parr = arr;
	else parr = brr;
	for (int i = 0; i<n; ++i)
	{
		for (int j = 0; j<m; ++j)
		{
			cout << parr[i][j] << ' ';
		}
		cout << '\n';
	}
}

void clockwise()
{
	int(*farr)[100];
	int(*tarr)[100];
	if (arrow == 0) farr = arr, tarr = brr;
	else farr = brr, tarr = arr;
	for (int i = 0; i<n; ++i)
	{
		for (int j = 0; j<m; ++j)
		{
			if (i < n / 2)
			{
				if (j < m / 2)
					tarr[i][j] = farr[i+n/2][j];
				else
					tarr[i][j] = farr[i][j-m/2];
			}
			else
			{
				if (j >= m / 2)
					tarr[i][j] = farr[i-n/2][j];
				else
					tarr[i][j] = farr[i][j+m/2];
			}
		}
	}
	arrow = 1 - arrow;
}

void counterClockwise()
{
	int(*farr)[100];
	int(*tarr)[100];
	if (arrow == 0) farr = arr, tarr = brr;
	else farr = brr, tarr = arr;
	for (int i = 0; i<n; ++i)
	{
		for (int j = 0; j<m; ++j)
		{
			if (i < n / 2)
			{
				if (j < m / 2)
					tarr[i][j] = farr[i][j+m/2];
				else
					tarr[i][j] = farr[i+n/2][j];
			}
			else
			{
				if (j >= m / 2)
					tarr[i][j] = farr[i][j-m/2];
				else
					tarr[i][j] = farr[i-n/2][j];
			}
		}
	}
	arrow = 1 - arrow;
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m >> calcN;
	for (int i = 0; i<n; ++i)
	{
		for (int j = 0; j<m; ++j)
		{
			cin >> arr[i][j];
		}
	}
	int calcType;
	for (int i = 0; i < calcN; ++i)
	{
		cin >> calcType;
		switch (calcType)
		{
		case 1:
			reverseTopDown(); break;
		case 2:
			reverseLtRt(); break;
		case 3:
			turnRight(); break;
		case 4:
			turnLeft(); break;
		case 5:
			clockwise(); break;
		default:
			counterClockwise(); break;
		}
	}
	printArr();
	return 0;
}