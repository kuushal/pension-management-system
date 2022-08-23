import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = 'http://35.154.204.241:8085/ProcessPension';

@Injectable({
  providedIn: 'root',
})
export class ProcessPensionServices {
  bankDetail = {
    id: '',
    bankName: '',
    accountNumber: '',
    typeOfBank: '',
  };
  constructor(private http: HttpClient) { }

  create(data: {
    aadhaarNumber: string;
    name: string;
    dateOfBirth: string;
    pan: string;
    salaryEarned: string;
    allowances: string;
    typeOfPension: string;
    bankDetail: object;
  }): Observable<any> {
    return this.http.post(baseUrl, data);
  }
}
