#include<stdio.h>
#include<stdlib.h>
struct node {
    int data;
    struct node*  prev;
    struct node* next; 
};
struct node* createnode(int data){
    struct node* temp=(struct node*)malloc(sizeof(struct node));
    temp->data=data;
    temp->next=temp->prev=NULL;
    return temp;
}
void traversal(struct node* head){
    struct node* curr=head;
    while(curr!=NULL){
        printf("%d\t",curr->data);
        curr=curr->next;
    }
}
void Btraversal(struct node* head){
    struct node* curr=head;
    while(curr->next!=NULL){
        curr=curr->next;
    }
    struct node* tail=curr;
    while(tail!=NULL){
        printf("%d\t",tail->data);
        tail=tail->prev;
    }

}
int findlength(struct node* head){
    int count=0;
    struct node* temp=head;
    for(temp=head;temp!=NULL;temp=temp->next){
        count++;
    }
    return count;
}
struct node* insertbeg(struct node* head, int data){
    struct node* new=createnode(data);
    if(head!=NULL){
        head->prev=new;
    }
    new->next=head;
    return new;
}
struct node* insertend(struct node* head,int data){
    struct node* new = createnode(data);
    if(head==NULL){
        head=new;
    }else{
        struct node* curr =head;
        while(curr->next!=NULL){
        curr=curr->next;
        }
        curr->next=new;
        new->prev=curr;
        new->next=NULL;
    }
    return head;
}
struct node* insertspec(struct node* head, int data,int pos){
    struct node* new=createnode(data);
    if(head==NULL){
        return new;
    }else{
        if(pos==1){
            return insertbeg(head,data);
        }
        if(pos>findlength(head)){
            return insertend(head,data);
        }
        struct node* curr=head;
        int i=1;
        while(i!=pos-1){
            curr=curr->next;
            i++;
        }
        new->next=curr->next;
        new->prev=curr->next->prev;
        curr->next->prev=new;
        curr->next=new;
        return head;   
    }
}
struct node* deletebeg(struct node* head){
    if(head==NULL){
        return NULL;
    }
    struct node* temp=head;
    head=head->next;
    if(head!=NULL){
        head->prev=NULL;
    }
    return temp;
}
struct node* deletend(struct node* head){
    if(head==NULL){
        return NULL;
    }
    struct node* temp=head;
    while(temp->next!=NULL){
        temp=temp->next;
    }
    temp->prev->next=NULL;
    free(temp);
    return head;
}
struct node* deletespecific(struct node* head,int pos){
    if(head==NULL){
        return NULL;
    }if(pos>findlength(head)){
        return head;
    }
    if(pos==1){
        return deletebeg(head);
    }
    struct node* curr= head;
    int i=1;
    while(i!=pos){
        curr=curr->next;
        i++;
    }
    curr->prev->next=curr->next;
    curr->next->prev=curr->prev;
    free(curr);
    return head;
}
void main(){
    printf("Start\n");
    struct node* head=createnode(14);
    head=insertbeg(head,13);
    head=insertbeg(head,12);
    head=insertbeg(head,11);
    head=insertend(head,15);
    head=insertend(head,16);
    head=insertend(head,17);
    head=insertend(head,18);
    traversal(head);
    printf("\n");
    printf("Length is:%d\n",findlength(head));
    //head=insertspec(head,53,9);
    head=deletespecific(head,4);
    traversal(head);
    printf("\nEnd");
    free(head);
}