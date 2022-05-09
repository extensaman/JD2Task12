import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Student} from "../views/student/student.component";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DataHandlerService {

  constructor(private http: HttpClient) {}

  getStudents(): Observable<Student[]> {
    const href = 'http://localhost:8081/Controller_war_exploded/';
    return this.http.get<Student[]>(href);
  }
}
