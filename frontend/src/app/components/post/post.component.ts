import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Post } from 'src/app/models';
import { PostService } from 'src/app/post.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  form!: FormGroup

  constructor(private fb: FormBuilder, private router: Router, private postService : PostService) { }

  ngOnInit(): void {
    this.form = this.postForm()
  }
  
  process(){
    const post: Post = this.form.value as Post
    console.log(post);
    this.postService.createPost(post) 
    .then(result => {
      console.log(result)
    }).catch(error => {
      console.error(error);
    })
    this.form = this.postForm()
  }

  private postForm() {
    return this.fb.group({
    name: this.fb.control('', [Validators.required, Validators.minLength(3) ]),
    email: this.fb.control('', [Validators.required, Validators.email]),
    phone: this.fb.control(''),
    title: this.fb.control('', [Validators.required, Validators.maxLength(128), Validators.minLength(5)]),
    description: this.fb.control('',[Validators.required]),
    image: this.fb.control('')
    })
  
  } 
  reset() {
  
  }

}
