import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom } from "rxjs";
import { Post } from "./models";

const URL = 'http://localhost:8080/api/posting'

@Injectable()
export class PostService {

  constructor(private http: HttpClient) { }

  // POST /api/posting
  // Add any required parameters or return type
  createPost(post: Post): Promise<any> {
     return firstValueFrom(this.http.post<any>(URL, post))
  }



}
