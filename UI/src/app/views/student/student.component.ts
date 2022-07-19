import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';
import {DataHandlerService} from "../../services/data-handler.service";


@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  displayedColumns: string[] = ['id', 'surname', 'name', 'patronymic', 'group', 'dateOfBirth'];
  dataSource: MatTableDataSource<Student>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private _httpClient: HttpClient, private dataHandler : DataHandlerService) {
    this.dataSource = new MatTableDataSource([]);
  }

  ngOnInit() {
      this.dataHandler.getStudents().subscribe(students => {
      this.dataSource.data = students;
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }
}

export class Student {
  id: number;
  surname: string;
  name: string;
  patronymic: string;
  group: string;
  dateOfBirth: Date;
}
