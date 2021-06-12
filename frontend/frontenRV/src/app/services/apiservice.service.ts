import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { RendezVous } from '../models/rendezVous';

@Injectable({
  providedIn: 'root'
})
export class ApiserviceService {

  private urlServeurApi= environment.urlServiceApi;

  constructor(private http: HttpClient) { }

  /**
   * getRvs
   */
  public getRvs():Observable<RendezVous[]> {
    return this.http.get<RendezVous[]>(this.urlServeurApi+"/getrvs");
  }
}
