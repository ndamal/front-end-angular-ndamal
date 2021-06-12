import { Component } from '@angular/core';
import { ApiserviceService } from './services/apiservice.service';
import { RendezVous } from './models/rendezVous';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'frontenRV';
  rvs:any=[];

  constructor(private serviceApi:ApiserviceService){}

  getAllRv(){
    this.serviceApi.getRvs()
    .subscribe(
      (data:RendezVous[])=>{
        console.log("data :"+data)
        this.rvs=data;
      },
      (error:HttpErrorResponse)=>{
        console.log("error :"+error)
      }
    );
  }

  ngOnInit():void{
    this.getAllRv();
  }
}
