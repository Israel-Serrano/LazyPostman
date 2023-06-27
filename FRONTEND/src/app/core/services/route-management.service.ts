import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RouteAssign } from '../models/interfaces/route-assign.interface';
import { Observable } from 'rxjs';
import { Itinerary } from '../models/interfaces/itinerary.interface';

@Injectable({
    providedIn: 'root'
})
export class RouteManagementService {
    private BASE_URL = 'http://localhost:8082/route-management';

    constructor(private http: HttpClient) { }

    assignRoute(idUser: number, idRoute: number):Observable<any> {
        const routeAssign: RouteAssign = { "routeId": idRoute, "userId": idUser };
        return this.http.post(this.BASE_URL + '/assign', routeAssign)
    }

    getRoutesUser(idUser: number): Observable<any> {
        return this.http.get(this.BASE_URL + '/users-routes/' + idUser);
    }

    getRoutesManager(idUser: number): Observable<any> {
        return this.http.get(this.BASE_URL + '/users-routes/' + idUser);
    }
    getRoute(idRoute:number):Observable<any>{//waypoint class
        return this.http.get(this.BASE_URL + '/route/'+idRoute);
    }

    getItinerary(idRoute:number):Observable<any>{
        return this.http.get(this.BASE_URL + '/itinerary/'+idRoute);
    }

}
